package kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import kamiltomczyk.recruitment.exchangeratesapp.R
import kamiltomczyk.recruitment.exchangeratesapp.data.models.Currency
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate
import kamiltomczyk.recruitment.exchangeratesapp.data.providers.Providers
import kamiltomczyk.recruitment.exchangeratesapp.data.states.UIState
import kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.view_model.ExchangeRatesViewModel
import kamiltomczyk.recruitment.exchangeratesapp.navigation.extension.withCurrency
import kamiltomczyk.recruitment.exchangeratesapp.navigation.routes.ExchangeRatesRoute
import kamiltomczyk.recruitment.exchangeratesapp.ui.components.AppToolbar
import kamiltomczyk.recruitment.exchangeratesapp.ui.components.CurrencyItem
import kamiltomczyk.recruitment.exchangeratesapp.ui.components.InfoText
import kamiltomczyk.recruitment.exchangeratesapp.ui.components.ProgressSpinner

@Composable
fun ExchangeRatesScreen() {
    val viewModel = Providers.localViewModelProvider.current as ExchangeRatesViewModel
    val navController = Providers.localNavControllerProvider.current
    val uiState: UIState by viewModel.uiState
    val exchangeRatesList: List<CurrencyRate>? by viewModel.currencyRatesState

    LaunchedEffect(Unit) {
        viewModel.getCurrentExchangeRates()
    }

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
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    ExchangeRates(
                        currencyRates = exchangeRatesList,
                        onCurrencyClickAction = { currency ->
                            navController?.navigate(ExchangeRatesRoute.Rate.withCurrency(currency))
                        }
                    )
                    if (uiState == UIState.InProgress)
                        ProgressSpinner(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    )
}

@Composable
fun ExchangeRates(
    currencyRates: List<CurrencyRate>?,
    onCurrencyClickAction: (currency: Currency) -> Unit
) {
    if (currencyRates.isNullOrEmpty()) {
        InfoText(
            text = stringResource(id = R.string.no_currencies_info)
        )
    } else {
        ExchangeRatesList(
            currencyRates = currencyRates,
            onCurrencyClickAction = onCurrencyClickAction
        )
    }
}

@Composable
fun ExchangeRatesList(
    currencyRates: List<CurrencyRate>,
    onCurrencyClickAction: (currency: Currency) -> Unit
) {
    LazyColumn {
        items(currencyRates) { currencyRate ->
            CurrencyItem(
                currencyRate = currencyRate,
                onClickAction = { currencyRateItem ->
                    onCurrencyClickAction(prepareCurrencyBaseOnRate(currencyRateItem))
                }
            )
        }
    }
}

fun prepareCurrencyBaseOnRate(currencyRate: CurrencyRate) = Currency(
    tableName = currencyRate.tableName,
    code = currencyRate.code
)