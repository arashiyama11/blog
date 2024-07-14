package tools

import tools.Page
import androidx.compose.runtime.MutableState

expect fun changePage(pageState: MutableState<Page>, newPage: Page)
