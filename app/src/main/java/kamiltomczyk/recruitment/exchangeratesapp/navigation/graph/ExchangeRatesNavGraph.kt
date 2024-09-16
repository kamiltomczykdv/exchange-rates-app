package kamiltomczyk.recruitment.exchangeratesapp.navigation.graph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.ui.ExchangeRatesScreen
import kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.ui.RateDetailScreen
import kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.view_model.ExchangeRatesViewModel
import kamiltomczyk.recruitment.exchangeratesapp.navigation.routes.ExchangeRatesRoute

@Composable
fun ExchangeRatesNavGraph(
    startDestination: String = ExchangeRatesRoute.CurrenciesRates.path,
    navController: NavHostController = rememberNavController(),
    exchangeRatesViewModel: ExchangeRatesViewModel = hiltViewModel<ExchangeRatesViewModel>()
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = ExchangeRatesRoute.CurrenciesRates.path) {
            ExchangeRatesScreen()
        }

        composable(route = ExchangeRatesRoute.Rate.path) {
            RateDetailScreen()
        }
    }
}