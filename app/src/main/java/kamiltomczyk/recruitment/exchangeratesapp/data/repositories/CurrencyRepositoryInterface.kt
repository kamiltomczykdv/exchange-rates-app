package kamiltomczyk.recruitment.exchangeratesapp.data.repositories

import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRateHistory

interface CurrencyRepositoryInterface {
    suspend fun getCurrentExchangeRates(): List<CurrencyRate>
    suspend fun getRatesOfCurrencyOfLastTwoWeeks(
        tableName: String,
        code: String
    ): CurrencyRateHistory?
}