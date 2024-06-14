package ir.androidCoder.photosmc.presentation.feature

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ir.androidCoder.photosmc.domain.model.PhotoResponse
import ir.androidCoder.photosmc.presentation.intent.MainIntent
import ir.androidCoder.photosmc.presentation.state.MainState
import ir.androidCoder.photosmc.presentation.viewModel.MainViewModel
import kotlin.random.Random

@Composable
fun PhotoScreen(viewModel: MainViewModel) {

    var data by remember { mutableStateOf<List<PhotoResponse.PhotoResponseItem>?>(null) }

    LaunchedEffect(Unit) {

        viewModel.dataIntent.send(MainIntent.FetchData)

        viewModel.photoData.collect{

            when(it){
                is MainState.Idle -> {}
                is MainState.Data -> {
                    data = it.data
                    Log.v("testData" , it.data.toString())
                }
                is MainState.Error -> {
                    Log.v("testData" , it.message.toString())
                }
            }

        }

    }


    Column(
        Modifier.fillMaxSize()
    ) {

        ToolbarPhotoScreen()

        if (data != null)
        Photos(data!!)


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarPhotoScreen(){

    TopAppBar(
        title = { Text(text = "Home")},
    )

}

@Composable
fun Photos(data: List<PhotoResponse.PhotoResponseItem>) {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {

        items(data.size) { it ->

            if (data.size > 1)
                PhotosItem(
                    Random.nextInt(200, 370).dp,
                    data[it]
                )

        }

    }

}

@Composable
fun PhotosItem(height: Dp, photoResponseItem: PhotoResponse.PhotoResponseItem) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(10.dp))
    ) {

        AsyncImage(
            model = photoResponseItem.urls.small,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

    }


}