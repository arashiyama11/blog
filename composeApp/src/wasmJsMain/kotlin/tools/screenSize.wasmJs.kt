package tools

import androidx.compose.runtime.Composable
import kotlinx.browser.window

@Composable
actual fun width() = window.innerWidth

@Composable
actual fun height() = window.innerHeight

actual fun webWidth(): Int? = window.innerWidth