package tools

import tools.Page
import androidx.compose.runtime.MutableState
import kotlinx.browser.window

actual fun changePage(pageState: MutableState<Page>, newPage: Page) {
  if (pageState.value == newPage) return
  val (title, page) = when (newPage) {
    Page.INDEX, Page.PROFILE -> "arashiyamaのプロフィール" to "profile"
    Page.PORTFOLIO -> "ポートフォリオ" to "portfolio"
    Page.NOT_FOUND -> "Not Found" to "not_found"
  }
  window.history.pushState(
    null,
    title,
    "${window.location.origin}${window.location.pathname}?page=$page"
  )
  pageState.component2()(newPage)
}