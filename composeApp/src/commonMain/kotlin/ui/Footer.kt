package ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import blog.composeapp.generated.resources.GitHubMark
import blog.composeapp.generated.resources.XMark
import blog.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import tools.jumpExternalPage

@Composable
fun Footer(modifier: Modifier, androidContext: Any?) {
  BottomAppBar(
    modifier = modifier,
    backgroundColor = Color.White
  ) {
    Column(modifier = Modifier.fillMaxWidth()) {
      Row(
        modifier = Modifier.fillMaxWidth().weight(3f)
          .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(20.dp))
      ) {
        IconButton(
          modifier = Modifier.fillMaxHeight().width(36.dp),
          //気が向いたらエラーハンドリングする
          onClick = { jumpExternalPage("https://github.com/arashiyama11", androidContext) }) {
          Icon(
            painterResource(Res.drawable.GitHubMark),
            contentDescription = "Localized description",
            modifier = Modifier.height(36.dp).width(36.dp)
          )
        }
        IconButton(
          modifier = Modifier.fillMaxHeight().width(36.dp),
          onClick = { jumpExternalPage("https://x.com/kamu_coins", androidContext) }) {
          Icon(
            painterResource(Res.drawable.XMark),
            contentDescription = "Localized description",
            modifier = Modifier.height(36.dp).width(36.dp)
          )
        }
      }
      Box(
        modifier = Modifier.fillMaxSize().weight(1f)
          .border(1.dp, Color.LightGray, shape = RoundedCornerShape(20.dp))
      ) {
        Text(
          "Copyright © 2024 arashiyama All Rights Reserved.",
          modifier = Modifier.fillMaxSize().wrapContentSize(),
          textAlign = TextAlign.Center
        )
      }
    }
  }
}