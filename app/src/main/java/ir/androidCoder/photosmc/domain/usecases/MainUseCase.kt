package ir.androidCoder.photosmc.domain.usecases

import ir.androidCoder.photosmc.domain.model.PhotoResponse
import kotlinx.coroutines.flow.Flow

interface MainUseCase {

    val getPhoto : Flow<PhotoResponse>

}