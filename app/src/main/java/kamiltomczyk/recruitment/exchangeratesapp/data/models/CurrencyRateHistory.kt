package kamiltomczyk.recruitment.exchangeratesapp.data.models

data class CurrencyRateHistory(
    val table: String? = null,
    val currency: String? = null,
    val code: String? = null,
    val rates: List<Rate>? = null
)