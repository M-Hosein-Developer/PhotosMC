package ir.androidCoder.photosmc.domain.usecases

import ir.androidCoder.photosmc.domain.model.PhotoResponse
import ir.androidCoder.photosmc.domain.repositories.MainRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainUseCaseImpl @Inject constructor(private val repository: MainRepository) : MainUseCase {

    override val getPhoto: Flow<PhotoResponse> = flow {
        while (true){
            repository.getPhoto.collect{
                emit(it)
            }
            delay(10000)
        }
    }


}