package tools

import Pages
import androidx.compose.runtime.MutableState

expect fun changePage(pageState: MutableState<Pages>, newPage: Pages)
