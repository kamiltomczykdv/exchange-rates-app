package kamiltomczyk.recruitment.exchangeratesapp.data.network

import kamiltomczyk.recruitment.exchangeratesapp.data.constants.DataConstants
import retrofit2.http.GET
import retrofit2.http.Path

interface NBPApiService {
    @GET(DataConstants.NBPApi.exchangeRatesForDates)
    suspend fun getExchangeRatesForDates(
        @Path(DataConstants.NBPApi.tableKey) table: String = DataConstants.NBPApi.tableAName,
        @Path(DataConstants.NBPApi.startDateKey) startDate: String,
        @Path(DataConstants.NBPApi.endDateKey) endDate: String
    )

    @GET(DataConstants.NBPApi.exchangeRatesForCode)
    suspend fun getExchangeRatesForCode(
        @Path(DataConstants.NBPApi.tableKey) table: String = DataConstants.NBPApi.tableAName,
        @Path(DataConstants.NBPApi.codeKey) code: String,
        @Path(DataConstants.NBPApi.startDateKey) startDate: String,
        @Path(DataConstants.NBPApi.endDateKey) endDate: String
    )
}