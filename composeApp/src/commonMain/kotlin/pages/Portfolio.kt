package pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.jPFontFamily

@Composable
@Preview
fun Portfolio() {
  val jpFont = jPFontFamily()
  Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
    Text("ポートフォリオページだよ", fontFamily = jpFont)
    Text("そのうち作るよ", fontFamily = jpFont)
  }
}