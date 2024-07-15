package tools

import android.content.Intent
import android.net.Uri
import android.content.Context

actual fun jumpExternalPage(url: String, androidContext: Any?): Boolean {
  if (androidContext is Context) {
    val browserIntent =
      Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK }
    androidContext.startActivity(browserIntent)
    return true
  } else return false
}