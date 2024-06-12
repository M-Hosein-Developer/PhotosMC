package ir.androidCoder.photosmc.presentation.state

import ir.androidCoder.photosmc.domain.model.PhotoResponse

sealed class MainState {
    
    data object Idle : MainState()
    data class Data(val data: PhotoResponse) : MainState()
    data class Error(val message: String?) : MainState()

}