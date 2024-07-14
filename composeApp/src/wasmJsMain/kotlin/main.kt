import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window

//どのhtmlをgetしてもこれが呼び出される
//パスパラメータで表示を変える
@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  ComposeViewport(document.body!!) {
    val currentPage = when (window.location.search) {
      "", "?page=index" -> Pages.INDEX
      "?page=profile" -> Pages.PROFILE
      "?page=portfolio" -> Pages.PORTFOLIO
      else -> Pages.NOTFOUND
    }
    App(currentPage)
  }
}