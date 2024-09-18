package kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import kamiltomczyk.recruitment.exchangeratesapp.R
import kamiltomczyk.recruitment.exchangeratesapp.data.constants.DataConstants
import kamiltomczyk.recruitment.exchangeratesapp.data.models.Currency
import kamiltomczyk.recruitment.exchangeratesapp.data.models.Rate
import kamiltomczyk.recruitment.exchangeratesapp.data.providers.Providers
import kamiltomczyk.recruitment.exchangeratesapp.data.states.UIState
import kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.view_model.ExchangeRatesViewModel
import kamiltomczyk.recruitment.exchangeratesapp.ui.components.AppToolbar
import kamiltomczyk.recruitment.exchangeratesapp.ui.components.HeaderText
import kamiltomczyk.recruitment.exchangeratesapp.ui.components.InfoText
import kamiltomczyk.recruitment.exchangeratesapp.ui.components.ProgressSpinner
import kamiltomczyk.recruitment.exchangeratesapp.ui.components.RateItem

@Composable
fun RateDetailScreen(currency: Currency) {
    val viewModel = Providers.localViewModelProvider.current as ExchangeRatesViewModel
    val navController = Providers.localNavControllerProvider.current
    val uiState: UIState by viewModel.uiState
    val averageRates: List<Rate>? by viewModel.ratesState

    LaunchedEffect(Unit) {
        viewModel.getRatesOfCurrencyOfLastTwoWeeks(
            tableName = currency.tableName ?: DataConstants.NBPApi.TABLE_A_NAME,
            code = currency.code ?: DataConstants.NBPApi.DEFAULT_CODE_KEY
        )
    }

    RateDetailView(
        onBackClickAction = { navController?.popBackStack() },
        currency = currency,
        averageRates = averageRates,
        uiState = uiState
    )
}

@Composable
fun RateDetailView(
    onBackClickAction: () -> Unit,
    currency: Currency,
    averageRates: List<Rate>?,
    uiState: UIState
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(id = R.string.currency_details_title),
                onBackClickAction = onBackClickAction
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
                    InfoSection(
                        currency = currency,
                        averageRates = averageRates
                    )
                    if (uiState == UIState.InProgress)
                        ProgressSpinner(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    )
}

@Composable
fun InfoSection(
    currency: Currency,
    averageRates: List<Rate>?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CurrencyInfoSection(currency)
        AverageRatesListSection(
            rates = averageRates,
            averageRate = currency.averageRate ?: DataConstants.NBPApi.DEFAULT_RATE_VALUE.toDouble()
        )
    }
}

@Composable
fun CurrencyInfoSection(currency: Currency) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(dimensionResource(id = R.dimen.standard_padding)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderText(
            text = currency.code ?: DataConstants.NBPApi.DEFAULT_CODE_KEY,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.standard_padding))
        )
        HeaderText(
            text = currency.tableName ?: DataConstants.NBPApi.TABLE_A_NAME,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.standard_padding))
        )
        HeaderText(
            text = currency.averageRate.toString(),
            modifier = Modifier.padding(dimensionResource(id = R.dimen.standard_padding))
        )
    }
}

@Composable
fun AverageRatesListSection(
    rates: List<Rate>?,
    averageRate: Double
) {
    if (rates.isNullOrEmpty()) {
        InfoText(
            text = stringResource(id = R.string.no_rates_info)
        )
    } else {
        RatesList(
            rates = rates,
            averageRate = averageRate
        )
    }
}

@Composable
fun RatesList(
    rates: List<Rate>,
    averageRate: Double
) {
    LazyColumn {
        items(rates) { rate ->
            RateItem(
                rate = rate,
                averageRate = averageRate
            )
        }
    }
}