package tools

import kotlinx.browser.window

actual fun onWindowResize(handler: () -> Unit) {
  window.onresize = { handler() }
}