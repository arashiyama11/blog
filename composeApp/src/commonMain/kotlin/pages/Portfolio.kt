package pages

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import tools.jPFontFamily

@Composable
@Preview
fun Portfolio() {
  val jpFont = jPFontFamily()
  LazyColumn(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
    item {
      Text("ポートフォリオページだよ", fontFamily = jpFont)
    }
    item {
      Text("そのうち作るよ", fontFamily = jpFont)
    }
    
    items(100) {
      Text("そのうち作るよ$it", fontFamily = jpFont)
    }
  }
}