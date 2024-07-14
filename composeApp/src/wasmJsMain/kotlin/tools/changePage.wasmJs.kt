package tools

import Pages
import androidx.compose.runtime.MutableState
import kotlinx.browser.window

actual fun changePage(pageState: MutableState<Pages>, newPage: Pages) {
  val (title, page) = when (newPage) {
    Pages.INDEX, Pages.PROFILE -> "arashiyamaのプロフィール" to "profile"
    Pages.PORTFOLIO -> "ポートフォリオ" to "portfolio"
    Pages.NOTFOUND -> "Not Found" to "not_found"
  }
  window.history.pushState(null, title, "${window.origin}?page=$page")
  pageState.component2()(newPage)
}