package kamiltomczyk.recruitment.exchangeratesapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import kamiltomczyk.recruitment.exchangeratesapp.R
import kamiltomczyk.recruitment.exchangeratesapp.data.constants.DataConstants

@Composable
fun HeaderText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        maxLines = DataConstants.LayoutValues.ONE_LINE_LIMIT_NUMBER,
        overflow = TextOverflow.Ellipsis,
        fontWeight = FontWeight.Normal,
        fontSize = dimensionResource(id = R.dimen.header_text_size).value.sp,
        color = Color.Black
    )
}

@Composable
fun InfoText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        overflow = TextOverflow.Ellipsis,
        fontWeight = FontWeight.Normal,
        fontSize = dimensionResource(id = R.dimen.info_text_size).value.sp,
        color = Color.DarkGray
    )
}

