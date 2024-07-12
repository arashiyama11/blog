import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import pages.NotFound
import pages.Portfolio
import pages.Profile

//どのhtmlをgetしてもこれが呼び出される
//パスパラメータで表示を変える
@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  ComposeViewport(document.body!!) {
    val path = window.location.pathname.let { if (it.startsWith("/blog/")) it else "/blog$it" }
    val currentPage = when (path) {
      "/blog/", "/blog/index.html" -> Pages.INDEX
      "/blog/profile.html" -> Pages.PROFILE
      "/blog/portfolio.html" -> Pages.PORTFOLIO
      else -> Pages.NOTFOUND
    }
    when (currentPage) {
      Pages.INDEX -> App()
      Pages.PROFILE -> Profile()
      Pages.PORTFOLIO -> Portfolio()
      Pages.NOTFOUND -> NotFound()
    }
  }
}