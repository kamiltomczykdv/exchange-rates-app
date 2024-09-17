package kamiltomczyk.recruitment.exchangeratesapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import kamiltomczyk.recruitment.exchangeratesapp.R
import kamiltomczyk.recruitment.exchangeratesapp.data.models.Rate
import kotlin.math.abs

@Composable
fun RateItem(
    rate: Rate,
    averageRate: Double
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.standard_corner_radius)),
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.standard_padding))
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.standard_padding))
                .fillMaxWidth()
                .background(
                    prepareColorForRate(
                        rateOfItem = rate.calculatedAverageRate,
                        averageRate = averageRate
                    )
                )
                .padding(horizontal = dimensionResource(id = R.dimen.standard_padding)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HeaderText(text = rate.effectiveDate)
            HeaderText(text = rate.calculatedAverageRate.toString())
        }
    }
}

fun prepareColorForRate(
    rateOfItem: Double,
    averageRate: Double
): Color {
    val threshold = averageRate * 0.1
    val difference = abs(rateOfItem - averageRate)

    return if (difference > threshold) Color.Red
    else Color.White
}