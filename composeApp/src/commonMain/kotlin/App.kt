import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import pages.*
import ui.LayoutBase

@Composable
@Preview
fun App(page: Pages = Pages.INDEX) {
  val pageState = remember { mutableStateOf(page) }
  MaterialTheme {
    LayoutBase(pageState) {
      when (pageState.value) {
        Pages.INDEX, Pages.PROFILE -> Profile()
        Pages.PORTFOLIO -> Portfolio()
        Pages.NOTFOUND -> NotFound()
      }
    }
  }
}

enum class Pages {
  INDEX, PROFILE, PORTFOLIO, NOTFOUND
}