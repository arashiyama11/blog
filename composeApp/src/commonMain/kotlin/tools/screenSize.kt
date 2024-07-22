package tools

import androidx.compose.runtime.Composable

@Composable
expect fun width(): Int

@Composable
expect fun height(): Int

//Webで画面サイズ変わったときのためにComposableじゃないwidthが欲しかった
expect fun webWidth(): Int?
