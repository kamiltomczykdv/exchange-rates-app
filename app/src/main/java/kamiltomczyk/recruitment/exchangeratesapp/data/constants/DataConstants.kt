package kamiltomczyk.recruitment.exchangeratesapp.data.constants

class DataConstants {
    object NBPApi {
        const val BASE_URL = "https://api.nbp.pl/api"
        const val CURRENT_EXCHANGE_RATES = "/exchangerates/tables/{table}/"
        const val RATES_OF_CURRENCY_FOR_DATE = "/exchangerates/rates/{table}/{code}/{startDate}/{endDate}/"
        const val TABLE_A_NAME = "a"
        const val TABLE_B_NAME = "b"
        const val TABLE_KEY = "table"
        const val CODE_KEY = "code"
        const val START_DATE_KEY = "startDate"
        const val END_DATE_KEY = "endDate"
    }
}