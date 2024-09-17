package kamiltomczyk.recruitment.exchangeratesapp.data.extension

import kamiltomczyk.recruitment.exchangeratesapp.data.constants.DataConstants
import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate
import kamiltomczyk.recruitment.exchangeratesapp.data.models.Rate
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun List<CurrencyRate>.addTableName(tableName: String) {
    forEach { currencyRate ->
        currencyRate.tableName = tableName
    }
}

fun List<Rate>.sortByDate(): List<Rate> {
    val formatter = DateTimeFormatter.ofPattern(DataConstants.Date.YEAR_FORMAT_VALUE)
    val sortedRates = sortedByDescending { LocalDate.parse(it.effectiveDate, formatter) }

    return sortedRates
}