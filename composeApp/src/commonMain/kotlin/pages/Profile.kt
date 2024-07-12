package pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.jPFontFamily

@Composable
@Preview
fun Profile() {
  val jpFont = jPFontFamily()
  Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
    Text("arashiyamaだよ", fontFamily = jpFont)
    Text("kotlin好き", fontFamily = jpFont)
  }
}