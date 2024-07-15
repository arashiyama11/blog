package tools

import kotlinx.browser.window

actual fun jumpExternalPage(url: String, androidContext: Any?): Boolean {
  window.location.href = url
  return true
}