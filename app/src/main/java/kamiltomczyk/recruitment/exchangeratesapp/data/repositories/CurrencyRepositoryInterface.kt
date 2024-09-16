package kamiltomczyk.recruitment.exchangeratesapp.data.repositories

import kamiltomczyk.recruitment.exchangeratesapp.data.enums.TableName
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate
import kamiltomczyk.recruitment.exchangeratesapp.data.models.Rate

interface CurrencyRepositoryInterface {
    suspend fun getCurrentExchangeRates(): List<CurrencyRate>
    suspend fun getRatesOfCurrencyOfLastTwoWeeks(
        tableName: TableName,
        code: String
    ): List<Rate>?
}