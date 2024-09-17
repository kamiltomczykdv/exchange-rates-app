package kamiltomczyk.recruitment.exchangeratesapp.ui.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import kamiltomczyk.recruitment.exchangeratesapp.R

@Composable
fun ProgressSpinner(
    modifier: Modifier
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = Color.Blue,
        strokeWidth = dimensionResource(id = R.dimen.standard_stroke_width)
    )
}