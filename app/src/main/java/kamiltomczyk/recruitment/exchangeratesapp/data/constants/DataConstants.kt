package kamiltomczyk.recruitment.exchangeratesapp.data.constants

class DataConstants {
    object NBPApi {
        const val baseUrl = "https://api.nbp.pl/api"
        const val exchangeRatesForDates =
            "/exchangerates/tables/{table}/{startDate}/{endDate}/"
        const val exchangeRatesForCode =
            "/exchangerates/rates/{table}/{code}/{startDate}/{endDate}/"
        const val tableAName = "a"
        const val tableKey = "table"
        const val startDateKey = "startDate"
        const val endDateKey = "endDate"
        const val codeKey = "code"
    }
}