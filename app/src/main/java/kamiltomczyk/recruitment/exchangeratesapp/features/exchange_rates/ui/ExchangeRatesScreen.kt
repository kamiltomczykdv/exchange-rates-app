package kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import kamiltomczyk.recruitment.exchangeratesapp.R
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate
import kamiltomczyk.recruitment.exchangeratesapp.data.providers.Providers
import kamiltomczyk.recruitment.exchangeratesapp.data.states.UIState
import kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.view_model.ExchangeRatesViewModel
import kamiltomczyk.recruitment.exchangeratesapp.ui.components.AppToolbar
import kamiltomczyk.recruitment.exchangeratesapp.ui.components.ProgressSpinner

@Composable
fun ExchangeRatesScreen() {
    val viewModel = Providers.localViewModelProvider.current as ExchangeRatesViewModel
    val navController = Providers.localNavControllerProvider.current
    val uiState: UIState by viewModel.uiState
    val exchangeRatesList: List<CurrencyRate>? by viewModel.currencyRatesState

    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(id = R.string.exchange_rates_title),
                onBackClickAction = {
                    navController?.popBackStack()
                }
            )
        },
        content = { padding ->
            Surface(
                color = Color.Gray,
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    ExchangeRatesList(exchangeRatesList)
                    if (uiState == UIState.InProgress)
                        ProgressSpinner(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    )
}

@Composable
fun ExchangeRatesList(currencyRatesState: List<CurrencyRate>?) {

}