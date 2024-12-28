import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import pages.*
import tools.Page
import tools.rewriteWebPagePath
import ui.BlogTheme
import ui.LayoutBase

@Composable
@Preview
fun App(page: Page = Page.INDEX) {
    var pageState by remember { mutableStateOf(page) }
    var isDarkTheme by remember { mutableStateOf(true) }
    BlogTheme(isDarkTheme) {
        LayoutBase({
            rewriteWebPagePath(pageState, it)
            pageState = it
        }, isDarkTheme, { isDarkTheme = !isDarkTheme }) {
            when (pageState) {
                Page.INDEX -> Index()
                Page.PROFILE -> Profile()
                Page.PORTFOLIO -> Portfolio()
                Page.NOT_FOUND -> NotFound()
            }
        }
    }
}