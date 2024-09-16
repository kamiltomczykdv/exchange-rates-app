package kamiltomczyk.recruitment.exchangeratesapp.data.repositories

import kamiltomczyk.recruitment.exchangeratesapp.data.network.NBPApiService

class CurrencyRepository(
    private val nbpApiService: NBPApiService
) : CurrencyRepositoryInterface {
    override suspend fun getCurrentExchangeRates() {

    }

    override suspend fun getRatesOfCurrencyOfLastTwoWeeks(table: String, code: String) {

    }

}