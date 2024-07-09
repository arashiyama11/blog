package ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.browser.document
import org.w3c.dom.HTMLElement

@Composable
actual fun MarkDown(source: String) {
  HtmlView(factory = {
    (document.createElement("md-block").cloneNode() as HTMLElement).apply {
      innerHTML = source
    }
  }, modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(100.dp))
}

