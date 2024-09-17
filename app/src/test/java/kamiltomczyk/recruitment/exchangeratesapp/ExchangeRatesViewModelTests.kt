package kamiltomczyk.recruitment.exchangeratesapp

import io.mockk.coEvery
import io.mockk.mockk
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRateHistory
import kamiltomczyk.recruitment.exchangeratesapp.data.repositories.CurrencyRepositoryInterface
import kamiltomczyk.recruitment.exchangeratesapp.features.exchange_rates.view_model.ExchangeRatesViewModel

class ExchangeRatesViewModelTests : BaseTest() {
    private val currencyRepositoryInterface: CurrencyRepositoryInterface = mockk(relaxed = true)
    private val exchangeRatesViewModel: ExchangeRatesViewModel = ExchangeRatesViewModel(
        currencyRepositoryInterface
    )

    private val exchangeRates: List<CurrencyRate> = listOf(
        CurrencyRate(
            currency = "test",
            code = "test",
            calculatedAverageRate = 0.0,
            tableName = "a"
        )
    )

    private val currencyRateHistory: CurrencyRateHistory = CurrencyRateHistory()

    private fun mockPositiveExchangeResponse() {
        coEvery { currencyRepositoryInterface.getCurrentExchangeRates() } returns exchangeRates
        coEvery { currencyRepositoryInterface.getRatesOfCurrencyOfLastTwoWeeks(any(), any()) } returns currencyRateHistory
    }

    // TODO:finish tests

}