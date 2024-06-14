package ir.androidCoder.photosmc.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.androidCoder.photosmc.presentation.feature.PhotoScreen
import ir.androidCoder.photosmc.presentation.ui.theme.PhotosMCTheme
import ir.androidCoder.photosmc.presentation.viewModel.MainViewModel
import ir.androidCoder.photosmc.util.MyScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PhotosMCTheme {
                
                MainUi(viewModel = viewModel)

            }
        }
    }
}

@Composable
fun MainUi(viewModel: MainViewModel) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        NavScreen(viewModel)

    }
}

@Composable
fun NavScreen(viewModel: MainViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MyScreen.PhotoScreen.route){

        composable(MyScreen.PhotoScreen.route){
            PhotoScreen(viewModel)
        }

    }

}

