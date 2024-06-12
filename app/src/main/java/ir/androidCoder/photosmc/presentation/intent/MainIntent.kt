package ir.androidCoder.photosmc.presentation.intent

sealed class MainIntent {

    data object FetchData : MainIntent()

}