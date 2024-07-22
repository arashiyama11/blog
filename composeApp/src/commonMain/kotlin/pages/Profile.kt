package pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Profile() {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    item {
      Text("Kotlin愛してるよ", style = MaterialTheme.typography.h1)
    }
    item {
      //Text("arashiyamaだよ", style = MaterialTheme.typography.h2)
    }
    items(100) {
      Text("- List item${it}", style = MaterialTheme.typography.body1)
    }
    item {
      Spacer(modifier = Modifier.height(50.dp))
    }
  }
}