import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

import kotlinx.coroutines.GlobalScope
import ui.MarkDown
import ui.jPFontFamily

@Composable
@Preview
fun App() {
  var response by remember { mutableStateOf("Wait...") }
  GlobalScope.launch {
    val res = getArticleMd("test.md")
    response = res
    println(res)
  }
  MaterialTheme {
    var showContent by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      Button(onClick = { showContent = !showContent }) {
        Text("click　みー", fontFamily = jPFontFamily())
      }
      AnimatedVisibility(showContent) {
        val greeting = remember { Greeting().greet() }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
          MarkDown(response)
        }
      }
    }
  }
}