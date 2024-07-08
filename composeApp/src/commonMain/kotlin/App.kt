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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

import blog.composeapp.generated.resources.Res
import blog.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.GlobalScope

@Composable
@Preview
fun App() {
  //TODO 日本語の文字化けなんとかする
  //最悪記事を英語で?
  var response by remember {
    mutableStateOf("Wait...")
  }
  GlobalScope.launch {
    println("start")
    val res = getArticleMd("test.md")
    response = res
    println(res)
  }
  MaterialTheme {
    var showContent by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      Button(onClick = { showContent = !showContent }) {
        Text("日本語が")
      }
      AnimatedVisibility(showContent) {
        val greeting = remember { Greeting().greet() }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
          Image(painterResource(Res.drawable.compose_multiplatform), null)
          Text("こんぽーず: $response", style = TextStyle())
        }
      }
    }
  }
}