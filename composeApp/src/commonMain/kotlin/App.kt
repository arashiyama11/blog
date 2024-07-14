import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import pages.Profile
import ui.LayoutBase

@Composable
@Preview
fun App() {
  MaterialTheme {
    LayoutBase {
      Profile()
    }
  }
}