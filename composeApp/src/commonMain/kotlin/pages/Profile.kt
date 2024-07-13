package pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
      BottomAppBar(modifier = Modifier) {
        IconButton(onClick = { /* do something */ }) {
          Icon(Icons.Filled.Check, contentDescription = "Localized description")
        }
      }
    }
    
  }
}