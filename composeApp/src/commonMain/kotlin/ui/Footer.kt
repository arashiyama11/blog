package ui

import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Footer() {
  BottomAppBar(modifier = Modifier) {
    IconButton(onClick = { /* do something */ }) {
      Icon(Icons.Filled.Check, contentDescription = "Localized description")
    }
  }
}