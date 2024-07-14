package tools

import tools.Page
import androidx.compose.runtime.MutableState

actual fun changePage(pageState: MutableState<Page>, newPage: Page) {
  if (pageState.value == newPage) return
  pageState.component2()(newPage)
}
