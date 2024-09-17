package kamiltomczyk.recruitment.exchangeratesapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import kamiltomczyk.recruitment.exchangeratesapp.R
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate

@Composable
fun CurrencyItem(
    currencyRate: CurrencyRate
) {
    Card(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.standard_padding))
    ) {

    }
}