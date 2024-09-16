package kamiltomczyk.recruitment.exchangeratesapp.data.enums

import kamiltomczyk.recruitment.exchangeratesapp.data.constants.DataConstants

enum class TableName(val value: String) {
    A(DataConstants.NBPApi.TABLE_A_NAME),
    B(DataConstants.NBPApi.TABLE_B_NAME)
}