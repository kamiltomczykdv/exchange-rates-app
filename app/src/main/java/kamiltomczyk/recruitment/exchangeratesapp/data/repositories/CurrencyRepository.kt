package kamiltomczyk.recruitment.exchangeratesapp.data.repositories

import kamiltomczyk.recruitment.exchangeratesapp.data.network.NBPApiService

class CurrencyRepository(
    private val nbpApiService: NBPApiService
) : CurrencyRepositoryInterface {

}