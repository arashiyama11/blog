import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import pages.*
import tools.Page
import ui.BlogTheme
import ui.LayoutBase

@Composable
@Preview
//contextはandroidのcontextだからここでは型が使えない
//外部サイト遷移のandroidのアプローチ汚い気がするのでなんとかしたい
fun App(page: Page = Page.INDEX, androidContext: Any? = null) {
  val pageState = remember { mutableStateOf(page) }
  val isD = isSystemInDarkTheme()
  val isDarkTheme = remember { mutableStateOf(isD) }
  BlogTheme(isDarkTheme.value) {
    LayoutBase(pageState, isDarkTheme, androidContext) {
      when (pageState.value) {
        Page.INDEX -> Index()
        Page.PROFILE -> Profile()
        Page.PORTFOLIO -> Portfolio()
        Page.NOT_FOUND -> NotFound()
      }
    }
  }
}