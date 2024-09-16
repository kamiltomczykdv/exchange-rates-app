package kamiltomczyk.recruitment.exchangeratesapp.data.states

sealed class UIState {
    data object Initialized : UIState()
    data object InProgress : UIState()

    data class Error(
        val code: Int? = null,
        val message: String?
    ) : UIState()

    data class NavigateTo(val key: String) : UIState()
}