package ui

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import blog.composeapp.generated.resources.Res
import blog.composeapp.generated.resources.BIZUDPGothic_Regular
import org.jetbrains.compose.resources.Font

@Composable
fun BlogTheme(isDark: Boolean, content: @Composable () -> Unit) {
    val typography = Typography(
        defaultFontFamily = FontFamily(Font(resource = Res.font.BIZUDPGothic_Regular)),
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
        body1 = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp
        ),
        body2 = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp
        ),
    )
    //背景#010409 sidebar#161b22 0d1117
    val colors = if (isDark) Colors(
        primary = Color(0xFF010409),//
        primaryVariant = Color.DarkGray,
        secondary = Color(0xFF161b22),
        secondaryVariant = Color.LightGray,
        background = Color(0xFF010409),//background
        surface = Color(0xFF0d1117),//カードとか
        error = Color.Red,
        onPrimary = Color.White,//文字など
        onSecondary = Color(0xFF151b23),//
        onBackground = Color.DarkGray,//枠線など
        onSurface = Color.LightGray,
        onError = Color.Black,
        isLight = false
    ) else Colors(
        primary = Color.White,//
        primaryVariant = Color.DarkGray,
        secondary = Color.LightGray,
        secondaryVariant = Color.LightGray,
        background = Color.White,//background
        surface = Color(0xFFBBBBBB),//カードとか
        error = Color.Red,
        onPrimary = Color.Black,//文字など
        onSecondary = Color.Black,//?
        onBackground = Color.LightGray,//枠線など
        onSurface = Color.Black,
        onError = Color.Black,
        isLight = true
    )
    MaterialTheme(colors = colors, typography = typography, content = content)
}
