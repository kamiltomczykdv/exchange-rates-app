package kamiltomczyk.recruitment.exchangeratesapp.navigation.extension

import kamiltomczyk.recruitment.exchangeratesapp.data.constants.DataConstants
import kamiltomczyk.recruitment.exchangeratesapp.data.models.Currency
import kamiltomczyk.recruitment.exchangeratesapp.navigation.routes.Route

fun Route.withCurrency(currency: Currency) =
    "$path/${currency.tableName}/${currency.code}/${currency.averageRate}"

fun Route.forCurrency() =
    "$path/{${DataConstants.InternalKeys.TABLE_INTERNAL_KEY}}/{${DataConstants.InternalKeys.CODE_INTERNAL_KEY}}/{${DataConstants.InternalKeys.AVERAGE_RATE_KEY}}"