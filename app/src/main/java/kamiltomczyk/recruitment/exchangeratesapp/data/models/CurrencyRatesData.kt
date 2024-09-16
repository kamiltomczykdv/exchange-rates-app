package kamiltomczyk.recruitment.exchangeratesapp.data.models

import com.google.gson.annotations.SerializedName

data class CurrencyRatesData(
    val table: String,
    @SerializedName("no") val tableNumber: String,
    val effectiveDate: String,
    val rates: List<CurrencyRate>
)