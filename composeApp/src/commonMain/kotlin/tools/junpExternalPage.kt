package tools

import androidx.compose.runtime.Composable


expect class JumpExternalPage(context:Any?){
    operator fun invoke(url: String): Boolean
}

@Composable
expect fun kmpLocalContext(): Any?