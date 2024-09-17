package kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kamiltomczyk.recruitment.exchangeratesapp.data.base.BaseViewModel
import kamiltomczyk.recruitment.exchangeratesapp.data.enums.TableName
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRateHistory
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

    private val internalCurrencyRateHistoryState: MutableState<CurrencyRateHistory?> =
        mutableStateOf(CurrencyRateHistory())
    val currencyRateHistoryState: State<CurrencyRateHistory?> = internalCurrencyRateHistoryState

    fun getCurrentExchangeRates() {
        executeAsynchronousAction {
            internalCurrencyRatesState.value = currencyRepositoryInterface.getCurrentExchangeRates()
        }
    }

    fun getRatesOfCurrencyOfLastTwoWeeks(tableName: String, code: String) {
        executeAsynchronousAction {
            internalCurrencyRateHistoryState.value = currencyRepositoryInterface
                .getRatesOfCurrencyOfLastTwoWeeks(
                    tableName = tableName,
                    code = code
                )
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