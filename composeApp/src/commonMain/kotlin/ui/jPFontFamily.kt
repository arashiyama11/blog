package ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import blog.composeapp.generated.resources.Res
import blog.composeapp.generated.resources.japanese
import org.jetbrains.compose.resources.Font

@Composable
fun jPFontFamily() = FontFamily(Font(resource = Res.font.japanese))
