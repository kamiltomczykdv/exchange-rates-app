package kamiltomczyk.recruitment.exchangeratesapp.data.models

import com.google.gson.annotations.SerializedName

data class Rate(
    @SerializedName("no") val tableNumber: String,
    val effectiveDate: String,
    @SerializedName("mid") val calculatedAverageRate: Double
)