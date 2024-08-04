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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import tools.changePage


@Composable
fun Sidebar(pageState: MutableState<Page>) {
  LazyColumn(
    modifier = Modifier.fillMaxHeight()
      .background(color = MaterialTheme.colors.secondary).width(300.dp),
    verticalArrangement = Arrangement.spacedBy(3.dp),
    contentPadding = PaddingValues(end = 5.dp)
  ) {
    item { sidebarLink("Home") { changePage(pageState, Page.INDEX) } }
    item { sidebarLink("Profile") { changePage(pageState, Page.PROFILE) } }
    item { sidebarLink("Portfolio") { changePage(pageState, Page.PORTFOLIO) } }
  }
}

@Composable
private fun sidebarLink(text: String, onClick: () -> Unit) = Text(
  text,
  modifier = Modifier
    .fillMaxWidth()
    .clickable(onClick = onClick)
    .height(50.dp).background(MaterialTheme.colors.surface, shape = RoundedCornerShape(4.dp))
    .wrapContentSize(),
  textAlign = TextAlign.Center,
  style = MaterialTheme.typography.h6
)