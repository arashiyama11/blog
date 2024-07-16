package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import blog.composeapp.generated.resources.GitHubMark
import blog.composeapp.generated.resources.XMark
import blog.composeapp.generated.resources.Res
import blog.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import tools.jumpExternalPage

@Composable
fun Footer(modifier: Modifier, androidContext: Any?) =
  BottomAppBar(
    modifier = modifier,
    backgroundColor = Color.White
  ) {
    Column(modifier = Modifier.fillMaxWidth()) {
      Row(
        modifier = Modifier.fillMaxWidth().weight(3f)
          .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(20.dp))
      ) {
        Column(
          modifier = Modifier.fillMaxHeight().weight(1f),
          verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          Text(" Links", fontSize = 30.sp, fontWeight = FontWeight.Bold)
          linkCard("X Account", Res.drawable.XMark) {
            jumpExternalPage(
              "https://x.com/kamu_coins",
              androidContext
            )
          }
          linkCard(
            "GitHub Profile",
            Res.drawable.GitHubMark
          ) { jumpExternalPage("https://github.com/arashiyama11", androidContext) }
          linkCard(
            "This Site's Repository",
            Res.drawable.GitHubMark
          ) { jumpExternalPage("https://github.com/arashiyama11/blog", androidContext) }
        }
        Column(
          modifier = Modifier.fillMaxHeight().weight(1f),
          verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          Text(
            " Contact",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
          )
          linkCard("X Direct Message", Res.drawable.XMark) {
            jumpExternalPage(
              "https://x.com/kamu_coins",
              androidContext
            )
          }
          linkCard("arashiyama1120@gmail.com", Icons.Default.Email) {}
        }
      }
      //コピーライト
      Column(
        modifier = Modifier.fillMaxSize().weight(1f)
          .border(1.dp, Color.LightGray, shape = RoundedCornerShape(20.dp))
      ) {
        Spacer(Modifier.weight(1f))
        Text(
          "Copyright © 2024 arashiyama All Rights Reserved",
          modifier = Modifier.weight(2f).fillMaxWidth().wrapContentSize(),
          textAlign = TextAlign.Center
        )
        
        Row(modifier = Modifier.weight(2f).fillMaxWidth().wrapContentWidth()) {
          Text(
            "Powered by Compose Multiplatform",
            modifier = Modifier,
            textAlign = TextAlign.Center
          )
          Image(painterResource(Res.drawable.compose_multiplatform), "compose_multiplatform")
        }
        Spacer(Modifier.weight(1f))
      }
    }
  }


@Composable
private fun linkCard(text: String, imageRes: DrawableResource, onClick: () -> Unit) = Card(
  modifier = Modifier.fillMaxWidth().height(36.dp)
    .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(6.dp))
    .clickable { onClick() }, shape = RoundedCornerShape(6.dp), elevation = 3.dp
) {
  Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
    Box(modifier = Modifier.fillMaxHeight().wrapContentHeight()) {
      Text(
        " $text",
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
      )
    }
    Image(
      painterResource(imageRes),
      text,
      modifier = Modifier.height(36.dp).width(36.dp)
    )
  }
}

@Composable
private fun linkCard(text: String, imageRes: ImageVector, onClick: () -> Unit) = Card(
  modifier = Modifier.fillMaxWidth().height(36.dp)
    .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(6.dp))
    .clickable { onClick() }, shape = RoundedCornerShape(6.dp), elevation = 3.dp
) {
  Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
    Box(modifier = Modifier.fillMaxHeight().wrapContentHeight()) {
      Text(
        " $text",
        fontSize = 16.sp,
        textAlign = TextAlign.Justify,
      )
    }
    Icon(imageRes, text, modifier = Modifier.height(36.dp).width(36.dp))
  }
}
