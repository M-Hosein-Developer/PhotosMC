package ir.androidCoder.photosmc.data.remote

import ir.androidCoder.photosmc.domain.model.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("photos/")
    suspend fun getPhotos(@Query("client_id") clientId: String): PhotoResponse

}