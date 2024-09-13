package tools

import androidx.compose.runtime.Composable
import kotlinx.browser.window

actual class JumpExternalPage actual constructor(context:Any?) {

  actual operator fun invoke(url: String): Boolean {
    window.location.href=url
    return true
  }
}

@Composable
actual fun kmpLocalContext() :Any? = null