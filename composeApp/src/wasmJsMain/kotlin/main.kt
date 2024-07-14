import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import tools.Page

//どのhtmlをgetしてもこれが呼び出される
//パスパラメータで表示を変える
@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  ComposeViewport(document.body!!) {
    val currentPage = when (window.location.search) {
      "", "?page=index" -> Page.INDEX
      "?page=profile" -> Page.PROFILE
      "?page=portfolio" -> Page.PORTFOLIO
      else -> Page.NOT_FOUND
    }
    App(currentPage)
  }
}