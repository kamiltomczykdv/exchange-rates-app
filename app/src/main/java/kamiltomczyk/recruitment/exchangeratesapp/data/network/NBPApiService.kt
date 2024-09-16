package kamiltomczyk.recruitment.exchangeratesapp.data.network

import kamiltomczyk.recruitment.exchangeratesapp.data.constants.DataConstants
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRateHistory
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRatesData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NBPApiService {
    @GET(DataConstants.NBPApi.CURRENT_EXCHANGE_RATES)
    suspend fun getCurrentExchangeRates(
        @Path(DataConstants.NBPApi.TABLE_KEY) table: String
    ): Response<CurrencyRatesData>

    @GET(DataConstants.NBPApi.RATES_OF_CURRENCY_FOR_DATE)
    suspend fun getRatesOfCurrencyForDate(
        @Path(DataConstants.NBPApi.TABLE_KEY) table: String,
        @Path(DataConstants.NBPApi.CODE_KEY) code: String,
        @Path(DataConstants.NBPApi.START_DATE_KEY) startDate: String,
        @Path(DataConstants.NBPApi.END_DATE_KEY) endDate: String,
    ): Response<CurrencyRateHistory>
}