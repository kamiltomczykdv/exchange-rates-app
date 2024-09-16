package kamiltomczyk.recruitment.exchangeratesapp.data.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kamiltomczyk.recruitment.exchangeratesapp.data.states.UIState
import kotlinx.coroutines.CoroutineExceptionHandler
import retrofit2.HttpException

abstract class BaseViewModel : ViewModel() {
    protected val protectedUIState: MutableState<UIState> = mutableStateOf(UIState.Initialized)
    val uiState: State<UIState> = protectedUIState

    protected val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        protectedUIState.value = if (exception is HttpException) {
            UIState.Error(
                code = exception.code(),
                message = exception.message
            )
        } else {
            UIState.Error(message = exception.message)
        }
        exception.printStackTrace()
    }
}