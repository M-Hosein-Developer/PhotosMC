package ir.androidCoder.photosmc.domain.repositories

import ir.androidCoder.photosmc.domain.model.PhotoResponse
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    val getPhoto : Flow<PhotoResponse>
}