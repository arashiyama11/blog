package pages

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun Portfolio() {
  LazyColumn(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
    item {
      Text("ポートフォリオページ", style = MaterialTheme.typography.h1)
    }
    item {
      Text("そのうち作る")
    }
    
    items(100) {
      Text("そのうち作るよ$it")
    }
  }
}