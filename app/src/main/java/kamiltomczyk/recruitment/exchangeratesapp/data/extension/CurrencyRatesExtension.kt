package kamiltomczyk.recruitment.exchangeratesapp.data.extension

import kamiltomczyk.recruitment.exchangeratesapp.data.models.CurrencyRate

fun List<CurrencyRate>.addTableName(tableName: String) {
    forEach { currencyRate ->
        currencyRate.tableName = tableName
    }
}