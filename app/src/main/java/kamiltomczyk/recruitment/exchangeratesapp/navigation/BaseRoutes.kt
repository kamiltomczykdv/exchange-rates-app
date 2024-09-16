package kamiltomczyk.recruitment.exchangeratesapp.navigation

object BaseRoutes {
    const val exchangeRates = "/exchange_rates"
    const val settings = "/settings"
}

sealed class Route(val path: String)