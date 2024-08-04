package pages

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Index() {
  LazyColumn(
    Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    contentPadding = PaddingValues(6.dp)
  ) {
    item { Text("arashiyama", style = MaterialTheme.typography.h1) }
    item { Spacer(modifier = Modifier.height(100.dp)) }
    item {
      Text(
        "About Me",
        style = MaterialTheme.typography.h3,
        textDecoration = TextDecoration.Underline
      )
      Spacer(Modifier.height(30.dp))
      Text(
        """筑波大学に通っている人です。
Kotlinを愛しています。
Web開発,Androidアプリ開発あたりを少しやっています。
暇なときはAtCoderで競技プログラミングしたり、機械学習周り触ってます。
あとバドミントンとかもやります。
詳しくはProfileページへ""", style = MaterialTheme.typography.body1
      )
    }
    item { Spacer(modifier = Modifier.height(100.dp)) }
    
    item {
      Text(
        "Skills",
        style = MaterialTheme.typography.h3,
        textDecoration = TextDecoration.Underline
      )
      
      FlowRow(modifier = Modifier.fillMaxWidth()) {
        for (i in 0..30) {
          
          Text("item$i")
        }
      }
    }
    
  }
}