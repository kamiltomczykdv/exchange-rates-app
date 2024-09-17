package kamiltomczyk.recruitment.exchangeratesapp.data.models

import com.google.gson.annotations.SerializedName

data class CurrencyRate(
    val currency: String,
    val code: String,
    @SerializedName("mid") val calculatedAverageRate: Double,
    var tableName: String? = null
)