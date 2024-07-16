package ui

import tools.Page
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tools.changePage
import tools.jPFontFamily

@Composable
fun Sidebar(pageState: MutableState<Page>) {
  LazyColumn(
    modifier = Modifier.fillMaxHeight()
      .background(color = Color.LightGray).width(300.dp),
    verticalArrangement = Arrangement.spacedBy(3.dp),
    contentPadding = PaddingValues(end = 5.dp)
  ) {
    item { sidebarLink("プロフィール") { changePage(pageState, Page.PROFILE) } }
    item { sidebarLink("ポートフォリオ") { changePage(pageState, Page.PORTFOLIO) } }
    items(100) {
      sidebarLink("item $it") { changePage(pageState, Page.NOT_FOUND) }
    }
  }
}

@Composable
private fun sidebarLink(text: String, onClick: () -> Unit) = Text(
  text,
  modifier = Modifier
    .fillMaxWidth()
    .clickable(onClick = onClick)
    .height(50.dp).background(Color.White, shape = RoundedCornerShape(4.dp)).wrapContentSize(),
  fontFamily = jPFontFamily(),
  textAlign = TextAlign.Center,
  fontSize = 20.sp,
  fontWeight = FontWeight.Bold
)