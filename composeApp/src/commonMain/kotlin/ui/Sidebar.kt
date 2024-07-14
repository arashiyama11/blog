package ui

import Pages
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tools.changePage
import tools.jPFontFamily

@Composable
fun Sidebar(pageState: MutableState<Pages>) {
  LazyColumn(
    modifier = Modifier.fillMaxHeight()
      .background(color = Color.LightGray).width(300.dp),
    verticalArrangement = Arrangement.spacedBy(3.dp),
    contentPadding = PaddingValues(end = 5.dp)
  ) {
    item { sideberLink("プロフィール") { changePage(pageState, Pages.PROFILE) } }
    item { sideberLink("ポートフォリオ") { changePage(pageState, Pages.PORTFOLIO) } }
    items(100) {
      sideberLink("item $it") { changePage(pageState, Pages.NOTFOUND) }
    }
  }
}

@Composable
private fun sideberLink(text: String, onClick: () -> Unit) = Text(
  text,
  modifier = Modifier
    .fillMaxWidth()
    .clickable(onClick = onClick)
    .height(50.dp).background(Color.White),
  fontFamily = jPFontFamily(),
  textAlign = TextAlign.Center,
  fontSize = 20.sp
)