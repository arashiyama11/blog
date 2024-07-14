package tools

import Pages
import androidx.compose.runtime.MutableState

actual fun changePage(pageState: MutableState<Pages>, newPage: Pages) =
  pageState.component2()(newPage)
