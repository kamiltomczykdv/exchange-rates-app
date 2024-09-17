package kamiltomczyk.recruitment.exchangeratesapp.data.providers

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import kamiltomczyk.recruitment.exchangeratesapp.data.base.BaseViewModel

object Providers {
    val localNavControllerProvider = compositionLocalOf<NavHostController?> { null }
    val localViewModelProvider = compositionLocalOf<BaseViewModel?> { null }
}