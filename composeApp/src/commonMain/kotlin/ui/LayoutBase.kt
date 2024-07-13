package ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import tools.width

@Composable
fun LayoutBase(content: @Composable (PaddingValues) -> Unit) {
  //600dp以下の場合は初期で隠す
  val showFlag = width().dp > 600.dp
  var showSidebar by remember { mutableStateOf(showFlag) }
  Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
    TopAppBar(backgroundColor = Color.Green) {
      Row {
        IconButton(onClick = { showSidebar = !showSidebar }) {
          Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        }
      }
    }
  }) {
    Row {
      AnimatedVisibility(showSidebar) {
        Sidebar()
      }
      content(it)
      Footer()
    }
  }
}