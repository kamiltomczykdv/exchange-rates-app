package kamiltomczyk.recruitment.exchangeratesapp.data.models

data class CurrencyRateHistory(
    val table: String,
    val currency: String,
    val code: String,
    val rates: List<Rate>
)