import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import pages.*
import tools.Page
import ui.BlogTheme
import ui.LayoutBase

@Composable
@Preview
//contextはandroidのcontextだからここでは型が使えない
fun App(page: Page = Page.INDEX) {
  val pageState = remember { mutableStateOf(page) }
  val isDarkTheme = remember { mutableStateOf(true) }
  BlogTheme(isDarkTheme.value) {
    LayoutBase(pageState, isDarkTheme) {
      when (pageState.value) {
        Page.INDEX -> Index()
        Page.PROFILE -> Profile()
        Page.PORTFOLIO -> Portfolio()
        Page.NOT_FOUND -> NotFound()
      }
    }
  }
}