package ir.androidCoder.photosmc.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.androidCoder.photosmc.domain.usecases.MainUseCase
import ir.androidCoder.photosmc.presentation.intent.MainIntent
import ir.androidCoder.photosmc.presentation.state.MainState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: MainUseCase) : ViewModel() {

    val dataIntent = Channel<MainIntent>()

    private val _photoData = MutableStateFlow<MainState>(MainState.Idle)
    val photoData: StateFlow<MainState> get() = _photoData

    init {
        intentHandle()
    }

    private fun intentHandle() = viewModelScope.launch {

        dataIntent.consumeAsFlow().collect {

            when (it) {
                is MainIntent.FetchData -> photoDataFun()
            }

        }

    }

    private fun photoDataFun() = viewModelScope.launch {

        useCase.getPhoto.catch {
            _photoData.value = MainState.Error(it.localizedMessage)
        }.collect {
            _photoData.value = MainState.Data(it)
        }

    }


}