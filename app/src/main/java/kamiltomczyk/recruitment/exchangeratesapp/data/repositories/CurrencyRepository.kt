package kamiltomczyk.recruitment.exchangeratesapp.data.repositories

import kamiltomczyk.recruitment.exchangeratesapp.data.date.getTwoWeeksDates
import kamiltomczyk.recruitment.exchangeratesapp.data.enums.TableName
import kamiltomczyk.recruitment.exchangeratesapp.data.extension.addTableName
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRateHistory
import kamiltomczyk.recruitment.exchangeratesapp.data.network.NBPApiService
import retrofit2.HttpException

class CurrencyRepository(
    private val nbpApiService: NBPApiService
) : CurrencyRepositoryInterface {
    override suspend fun getCurrentExchangeRates(): List<CurrencyRate> {
        val ratesOfTableA = getExchangeRatesForTable(TableName.A) ?: listOf()
        val ratesOfTableB = getExchangeRatesForTable(TableName.B) ?: listOf()

        return ratesOfTableA + ratesOfTableB
    }

    override suspend fun getRatesOfCurrencyOfLastTwoWeeks(
        tableName: String,
        code: String
    ): CurrencyRateHistory? {
        val twoWeeksDates = getTwoWeeksDates()

        val response = nbpApiService.getRatesOfCurrencyForDate(
            table = tableName,
            code = code,
            startDate = twoWeeksDates.startDate,
            endDate = twoWeeksDates.endDate
        )

        if (!response.isSuccessful) {
            throw HttpException(response)
        }

        return response.body()
    }

    private suspend fun getExchangeRatesForTable(tableName: TableName): List<CurrencyRate>? {
        val response = nbpApiService.getCurrentExchangeRates(tableName.value)

        if (!response.isSuccessful) {
            throw HttpException(response)
        }

        val currencyRatesData = response.body()
        val currencyRates = currencyRatesData?.get(0)?.rates

        currencyRates?.addTableName(tableName.value)
        return currencyRates
    }
}