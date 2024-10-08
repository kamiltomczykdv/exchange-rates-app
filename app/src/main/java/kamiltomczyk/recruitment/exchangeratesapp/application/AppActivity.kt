package kamiltomczyk.recruitment.exchangeratesapp.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import kamiltomczyk.recruitment.exchangeratesapp.navigation.graph.ExchangeRatesNavGraph
import kamiltomczyk.recruitment.exchangeratesapp.ui.theme.ExchangeRatesAppTheme

@AndroidEntryPoint
class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExchangeRatesAppTheme {
                ExchangeRatesNavGraph()
            }
        }
    }
}