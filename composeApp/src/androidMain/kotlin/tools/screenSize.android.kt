package tools

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
actual fun width() = LocalConfiguration.current.screenWidthDp

@Composable
actual fun height() = LocalConfiguration.current.screenHeightDp