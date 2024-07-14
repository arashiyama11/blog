import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import pages.*
import tools.Page
import ui.LayoutBase

@Composable
@Preview
fun App(page: Page = Page.INDEX) {
  val pageState = remember { mutableStateOf(page) }
  MaterialTheme {
    LayoutBase(pageState) {
      when (pageState.value) {
        Page.INDEX, Page.PROFILE -> Profile()
        Page.PORTFOLIO -> Portfolio()
        Page.NOT_FOUND -> NotFound()
      }
    }
  }
}