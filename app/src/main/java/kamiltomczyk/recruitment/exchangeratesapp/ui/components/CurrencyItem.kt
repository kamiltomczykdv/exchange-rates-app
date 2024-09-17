package kamiltomczyk.recruitment.exchangeratesapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import kamiltomczyk.recruitment.exchangeratesapp.R
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate

@Composable
fun CurrencyItem(
    currencyRate: CurrencyRate,
    onClickAction: (currencyRate: CurrencyRate) -> Unit
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.standard_corner_radius)),
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.standard_padding))
    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .clickable { onClickAction.invoke(currencyRate) },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoSection(currencyRate)
            ImageSection(currencyRate.tableName)
        }
    }
}

@Composable
fun InfoSection(currencyRate: CurrencyRate) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        HeaderText(text = currencyRate.currency)
        InfoText(text = currencyRate.code)
        InfoText(
            text = stringResource(id = R.string.average_rate_text) + currencyRate.calculatedAverageRate.toString()
        )
    }
}

@Composable
fun ImageSection(tableName: String?) {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Rounded.DateRange,
            contentDescription = stringResource(id = R.string.currency_icon_description)
        )
        InfoText(text = tableName ?: "")
    }
}