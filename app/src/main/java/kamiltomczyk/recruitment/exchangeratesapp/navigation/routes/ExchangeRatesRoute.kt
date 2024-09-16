package kamiltomczyk.recruitment.exchangeratesapp.navigation.routes

class ExchangeRatesRoute {
    data object CurrenciesRates : Route(BaseRoutes.exchangeRates + "/currencies_rates")
    data object Rate : Route(BaseRoutes.exchangeRates + "/rate")
}