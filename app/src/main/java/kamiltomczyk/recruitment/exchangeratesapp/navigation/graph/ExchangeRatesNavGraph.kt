package kamiltomczyk.recruitment.exchangeratesapp.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kamiltomczyk.recruitment.exchangeratesapp.data.constants.DataConstants
import kamiltomczyk.recruitment.exchangeratesapp.data.models.Currency
import kamiltomczyk.recruitment.exchangeratesapp.data.providers.Providers
import kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.ui.ExchangeRatesScreen
import kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.ui.RateDetailScreen
import kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.view_model.ExchangeRatesViewModel
import kamiltomczyk.recruitment.exchangeratesapp.navigation.extension.forCurrency
import kamiltomczyk.recruitment.exchangeratesapp.navigation.routes.ExchangeRatesRoute

@Composable
fun ExchangeRatesNavGraph(
    startDestination: String = ExchangeRatesRoute.CurrenciesRates.path,
    navController: NavHostController = rememberNavController(),
    exchangeRatesViewModel: ExchangeRatesViewModel = hiltViewModel<ExchangeRatesViewModel>()
) {
    with(Providers) {
        CompositionLocalProvider(
            localNavControllerProvider provides navController,
            localViewModelProvider provides exchangeRatesViewModel
        ) {
            NavHost(navController = navController, startDestination = startDestination) {
                composable(route = ExchangeRatesRoute.CurrenciesRates.path) {
                    ExchangeRatesScreen()
                }

                composable(route = ExchangeRatesRoute.Rate.forCurrency()) { backStackEntry ->
                    RateDetailScreen(getCurrency(backStackEntry))
                }
            }
        }
    }
}

fun getCurrency(backStackEntry: NavBackStackEntry): Currency {
    val tableName =
        backStackEntry.arguments?.getString(DataConstants.InternalKeys.TABLE_INTERNAL_KEY)
    val code = backStackEntry.arguments?.getString(DataConstants.InternalKeys.CODE_INTERNAL_KEY)
    val averageRate =
        backStackEntry.arguments?.getString(DataConstants.InternalKeys.AVERAGE_RATE_KEY)

    return Currency(
        tableName = tableName,
        code = code,
        averageRate = averageRate?.toDouble()
    )
}