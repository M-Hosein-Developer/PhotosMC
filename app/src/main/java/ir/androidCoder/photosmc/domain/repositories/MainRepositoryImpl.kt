package ir.androidCoder.photosmc.domain.repositories

import ir.androidCoder.photosmc.data.remote.ApiService
import ir.androidCoder.photosmc.domain.model.PhotoResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiService: ApiService) : MainRepository {

    override val getPhoto: Flow<PhotoResponse> = flow {
        while (true){
            emit(apiService.getPhotos("cHrEYuOkjgsNihjYNRpvMpRQsw3PZxKY1jBGXRol3mc"))
            delay(10000)
        }
    }



}