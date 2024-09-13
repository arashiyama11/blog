package tools

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


actual class JumpExternalPage actual constructor(context:Any?) {
    private val _context = context
    actual operator fun invoke(url: String): Boolean {
        (_context as Context).startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK })
        return true
    }
}

@Composable
actual fun kmpLocalContext():Any? = LocalContext.current