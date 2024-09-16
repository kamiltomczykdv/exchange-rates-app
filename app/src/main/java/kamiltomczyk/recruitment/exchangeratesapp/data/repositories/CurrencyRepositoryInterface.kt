package kamiltomczyk.recruitment.exchangeratesapp.data.repositories

interface CurrencyRepositoryInterface {
    suspend fun getCurrentExchangeRates()
    suspend fun getRatesOfCurrencyOfLastTwoWeeks(
        table: String,
        code: String
    )
}