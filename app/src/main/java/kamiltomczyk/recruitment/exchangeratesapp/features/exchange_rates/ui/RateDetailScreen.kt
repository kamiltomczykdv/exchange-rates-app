package kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import kamiltomczyk.recruitment.exchangeratesapp.data.models.Currency
import kamiltomczyk.recruitment.exchangeratesapp.data.providers.Providers
import kamiltomczyk.recruitment.exchangeratesapp.data.states.UIState
import kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.view_model.ExchangeRatesViewModel

@Composable
fun RateDetailScreen(currency: Currency) {
    val viewModel = Providers.localViewModelProvider.current as ExchangeRatesViewModel
    val uiState: UIState by viewModel.uiState

}