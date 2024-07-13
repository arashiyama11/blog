import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import pages.Profile
import ui.LayoutBase

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App() {
  MaterialTheme {
    LayoutBase {
      Profile()
    }
  }
}