package ui

import androidx.compose.foundation.border
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Footer(modifier: Modifier) {
  BottomAppBar(
    modifier = modifier.border(width = 3.dp, color = Color.LightGray),
    backgroundColor = Color.White
  ) {
    IconButton(onClick = { /* do something */ }) {
      Icon(Icons.Filled.Check, contentDescription = "Localized description")
    }
  }
}