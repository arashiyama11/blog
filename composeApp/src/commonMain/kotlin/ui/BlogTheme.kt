package ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import tools.jPFontFamily

@Composable
fun BlogTheme(content: @Composable () -> Unit) {
  val typography = Typography(
    defaultFontFamily = jPFontFamily(),
    h1 = TextStyle(
      fontWeight = FontWeight.Bold,
      fontSize = 48.sp,
      lineHeight = 60.sp,
      letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
      fontWeight = FontWeight.Bold,
      fontSize = 40.sp,
      lineHeight = 52.sp,
      letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
      fontWeight = FontWeight.Bold,
      fontSize = 32.sp,
      lineHeight = 44.sp,
      letterSpacing = 0.sp
    ),
    h4 = TextStyle(
      fontWeight = FontWeight.Bold,
      fontSize = 28.sp,
      lineHeight = 28.sp,
      letterSpacing = 0.25.sp
    ),
    h5 = TextStyle(
      fontWeight = FontWeight.Bold,
      fontSize = 24.sp,
      lineHeight = 24.sp,
      letterSpacing = 0.sp
    ),
    h6 = TextStyle(
      fontWeight = FontWeight.ExtraBold,
      fontSize = 20.sp,
      lineHeight = 20.sp,
      letterSpacing = 0.15.sp
    ),
  )
  MaterialTheme(typography = typography, content = content)
}
