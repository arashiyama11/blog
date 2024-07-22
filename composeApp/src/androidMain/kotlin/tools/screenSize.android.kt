package tools

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
actual fun width() = LocalConfiguration.current.screenWidthDp

@Composable
actual fun height() = LocalConfiguration.current.screenHeightDp
actual fun webWidth(): Int? = null