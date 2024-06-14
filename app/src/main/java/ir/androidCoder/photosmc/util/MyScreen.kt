package ir.androidCoder.photosmc.util

sealed class MyScreen(val route: String) {

    data object PhotoScreen : MyScreen("photoScreen")

}