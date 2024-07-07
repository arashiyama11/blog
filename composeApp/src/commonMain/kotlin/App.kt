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
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import  okio.*
import kotlinx.coroutines.launch
import fetch

import blog.composeapp.generated.resources.Res
import blog.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.GlobalScope

@Composable
@Preview
fun App() {
  MaterialTheme {
    var showContent by remember { mutableStateOf(false) }
    var response by remember {
      mutableStateOf("Wait...")
    }
    GlobalScope.launch {
      println("start")
      val res = fetch("https://api.github.com/repos/arashiyama11/blog")
      response = res
      println(res)
    }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      Button(onClick = { showContent = !showContent }) {
        Text(response)
      }
      AnimatedVisibility(showContent) {
        val greeting = remember { Greeting().greet() }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
          Image(painterResource(Res.drawable.compose_multiplatform), null)
          Text("Compose: $greeting")
        }
      }
    }
  }
  
  
}