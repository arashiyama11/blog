package tools

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

@Composable
actual fun width() = window.innerWidth

@Composable
actual fun height() = window.innerHeight