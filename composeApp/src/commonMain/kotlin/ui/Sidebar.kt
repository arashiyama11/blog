package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tools.jPFontFamily

@Composable
fun Sidebar() {
  LazyColumn(
    modifier = Modifier.fillMaxHeight()
      .background(color = Color.LightGray).width(300.dp),
    verticalArrangement = Arrangement.spacedBy(3.dp),
    contentPadding = PaddingValues(end = 5.dp)
  ) {
    items(100) {
      Text(
        "プロフィール",
        modifier = Modifier
          .fillMaxWidth()
          .clickable { }
          .height(50.dp).background(Color.White),
        fontFamily = jPFontFamily(),
        textAlign = TextAlign.Center,
        fontSize = 20.sp
      )
    }
  }
}