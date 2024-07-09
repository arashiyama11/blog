package ui

import androidx.compose.runtime.Composable
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.BasicRichText

@Composable
actual fun MarkDown(source: String) {
  BasicRichText {
    Markdown(source)
  }
}