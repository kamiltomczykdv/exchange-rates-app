package kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kamiltomczyk.recruitment.exchangeratesapp.data.base.BaseViewModel
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate
import kamiltomczyk.recruitment.exchangeratesapp.data.models.Rate
import kamiltomczyk.recruitment.exchangeratesapp.data.repositories.CurrencyRepositoryInterface
import kamiltomczyk.recruitment.exchangeratesapp.data.states.UIState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeRatesViewModel @Inject constructor(
    private val currencyRepositoryInterface: CurrencyRepositoryInterface
) : BaseViewModel() {
    private val internalCurrencyRatesState: MutableState<List<CurrencyRate>?> = mutableStateOf(
        listOf()
    )
    val currencyRatesState: State<List<CurrencyRate>?> = internalCurrencyRatesState

    private val internalRatesState: MutableState<List<Rate>?> =
        mutableStateOf(listOf())
    val ratesState: State<List<Rate>?> = internalRatesState

    fun getCurrentExchangeRates() {
        executeAsynchronousAction {
            internalCurrencyRatesState.value = currencyRepositoryInterface.getCurrentExchangeRates()
        }
    }

    fun getRatesOfCurrencyOfLastTwoWeeks(tableName: String, code: String) {
        executeAsynchronousAction {
            internalRatesState.value = currencyRepositoryInterface
                .getRatesOfCurrencyOfLastTwoWeeks(
                    tableName = tableName,
                    code = code
                )?.rates
        }
    }

    private fun executeAsynchronousAction(action: suspend () -> Unit) {
        viewModelScope.launch(exceptionHandler) {
            protectedUIState.value = UIState.InProgress
            action.invoke()
            protectedUIState.value = UIState.OnResults
        }
    }
}