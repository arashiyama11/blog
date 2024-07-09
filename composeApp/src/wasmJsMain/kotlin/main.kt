import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import kotlinx.browser.document
import ui.LocalLayerContainer

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  CanvasBasedWindow(canvasElementId = "ComposeTarget") {
    CompositionLocalProvider(LocalLayerContainer provides document.getElementById("components")!!) {
      App()
    }
  }
}