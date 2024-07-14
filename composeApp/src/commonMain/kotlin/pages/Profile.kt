package pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import tools.jPFontFamily

@Preview
@Composable
fun Profile() {
  val jpFont = jPFontFamily()
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    item {
      Text("kotlin好き", fontFamily = jpFont)
    }
    item {
      Text("arashiyamaだよ", fontFamily = jpFont)
    }
    items(100) {
      Text("- List item${it}")
    }
    item {
      Spacer(modifier = Modifier.height(50.dp))
    }
  }
}