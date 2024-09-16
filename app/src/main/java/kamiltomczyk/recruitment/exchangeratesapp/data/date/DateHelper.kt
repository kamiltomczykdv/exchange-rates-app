package kamiltomczyk.recruitment.exchangeratesapp.data.date

import kamiltomczyk.recruitment.exchangeratesapp.data.constants.DataConstants
import kamiltomczyk.recruitment.exchangeratesapp.data.models.TwoWeeksDates
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun getTwoWeeksDates(): TwoWeeksDates {
    val formatter = SimpleDateFormat(DataConstants.Date.YEAR_FORMAT_VALUE, Locale.getDefault())

    val calendar = Calendar.getInstance()
    val today = formatter.format(calendar.time)

    calendar.add(Calendar.DAY_OF_YEAR, -DataConstants.Date.TWO_WEEKS_DAYS_NUMBER)
    val fourteenDaysBefore = formatter.format(calendar.time)

    return TwoWeeksDates(
        startDate = fourteenDaysBefore,
        endDate = today
    )
}