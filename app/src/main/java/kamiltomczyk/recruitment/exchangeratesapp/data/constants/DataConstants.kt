package kamiltomczyk.recruitment.exchangeratesapp.data.constants

class DataConstants {
    object NBPApi {
        const val BASE_URL = "https://api.nbp.pl/api/"
        const val CURRENT_EXCHANGE_RATES = "exchangerates/tables/{table}/"
        const val RATES_OF_CURRENCY_FOR_DATE =
            "exchangerates/rates/{table}/{code}/{startDate}/{endDate}/"
        const val TABLE_A_NAME = "a"
        const val TABLE_B_NAME = "b"
        const val DEFAULT_CODE_KEY = "USD"
        const val TABLE_KEY = "table"
        const val CODE_KEY = "code"
        const val DEFAULT_RATE_VALUE = "0.0"
        const val START_DATE_KEY = "startDate"
        const val END_DATE_KEY = "endDate"
    }

    object Date {
        const val YEAR_FORMAT_VALUE = "yyyy-MM-dd"
        const val TWO_WEEKS_DAYS_NUMBER = 14
    }

    object InternalKeys {
        const val TABLE_INTERNAL_KEY = "table"
        const val CODE_INTERNAL_KEY = "code"
        const val AVERAGE_RATE_KEY = "averageRate"
    }

    object LayoutValues {
        const val BACK_ARROW_ROTATION = 270f
        const val ONE_LINE_LIMIT_NUMBER = 1
    }
}