package kamiltomczyk.recruitment.exchangeratesapp.data.models

import kamiltomczyk.recruitment.exchangeratesapp.data.enums.TableName

data class Currency(
    val tableName: TableName,
    val code: String
)
