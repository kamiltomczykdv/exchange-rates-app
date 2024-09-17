package kamiltomczyk.recruitment.exchangeratesapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import kamiltomczyk.recruitment.exchangeratesapp.R
import kamiltomczyk.recruitment.exchangeratesapp.data.constants.DataConstants

@Composable
fun AppToolbar(
    title: String,
    onBackClickAction: (() -> Unit)? = null,
    onHelpClickAction: (() -> Unit)? = null
) {
    Surface(
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BackButton(onBackClickAction)
            TitleText(title)
            HelpButton(onHelpClickAction)
        }
    }
}

@Composable
fun BackButton(
    onBackClickAction: (() -> Unit)?
) {
    Icon(
        imageVector = Icons.Rounded.KeyboardArrowUp,
        modifier = Modifier
            .rotate(DataConstants.LayoutValues.BACK_ARROW_ROTATION)
            .clickable { onBackClickAction?.invoke() },
        contentDescription = stringResource(id = R.string.back_button_description)
    )
}

@Composable
fun TitleText(
    text: String
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
fun HelpButton(
    onHelpClickAction: (() -> Unit)?
) {
    Icon(
        imageVector = Icons.Rounded.Info,
        modifier = Modifier
            .rotate(DataConstants.LayoutValues.BACK_ARROW_ROTATION)
            .clickable { onHelpClickAction?.invoke() },
        contentDescription = stringResource(
            id = R.string.help_button_description
        )
    )
}