package ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import tools.width

@Composable
fun LayoutBase(content: @Composable (PaddingValues) -> Unit) {
  val headerHeight = 50.dp
  val maxFooterHeight = 300.dp
  val wideMode = width().dp > 600.dp
  var showSidebar by remember { mutableStateOf(wideMode) }
  val density = LocalDensity.current
  val scrollState = remember {
    ConnectionScrollStateImpl(
      maxOffset = maxFooterHeight,
      initialOffset = maxFooterHeight,
      density = density,
    )
  }
  Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
    TopAppBar(modifier = Modifier.height(headerHeight), backgroundColor = Color.Green) {
      Row {
        IconButton(onClick = { showSidebar = !showSidebar }) {
          Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        }
      }
    }
  }) {
    
    if (wideMode) Row(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
      AnimatedVisibility(
        showSidebar,
        enter = expandHorizontally(), exit = shrinkHorizontally()
      ) {
        Sidebar()
      }
      Column(verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxHeight()) {
        Column(
          modifier = Modifier.padding(horizontal = 100.dp)
            .border(2.dp, Color.LightGray, shape = RoundedCornerShape(20.dp))
            .nestedScroll(scrollState.nestedScrollConnection)
            .height(tools.height().dp - headerHeight - maxFooterHeight + scrollState.offset)
        ) {
          content(it)
        }
        Footer(
          modifier = Modifier.fillMaxWidth().height(maxFooterHeight - scrollState.offset)
        )
      }
    }
    else Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
      Column(verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxHeight()) {
        Column(
          modifier = Modifier
            .border(2.dp, Color.LightGray, shape = RoundedCornerShape(20.dp))
            .nestedScroll(scrollState.nestedScrollConnection)
            .height(tools.height().dp - headerHeight - maxFooterHeight + scrollState.offset)
        ) {
          content(it)
        }
        Footer(
          modifier = Modifier.fillMaxWidth().height(maxFooterHeight - scrollState.offset)
        )
      }
      AnimatedVisibility(
        showSidebar, modifier = Modifier.background(color = Color.LightGray),
        enter = expandHorizontally(), exit = shrinkHorizontally()
      ) {
        Sidebar()
      }
    }
  }
}


@Stable
class ConnectionScrollStateImpl(
  maxOffset: Dp,
  initialOffset: Dp,
  private val density: Density,
) {
  private val maxOffsetPx = with(density) { maxOffset.toPx() }
  private val initialOffsetPx = with(density) { initialOffset.toPx() }
  private var _offsetPx by mutableFloatStateOf(initialOffsetPx)
  val offset: Dp
    get() = with(density) { _offsetPx.toDp() }
  
  val nestedScrollConnection = object : NestedScrollConnection {
    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
      if (available.y <= 0f) return Offset.Zero
      val consumedY = doScroll(available.y)
      return Offset(0f, consumedY)
    }
    
    override fun onPostScroll(
      consumed: Offset,
      available: Offset,
      source: NestedScrollSource
    ): Offset {
      if (available.y >= 0f) return Offset.Zero
      val consumedY = doScroll(available.y)
      return Offset(0f, consumedY)
    }
  }
  
  private fun doScroll(delta: Float): Float {
    val oldOffset = _offsetPx
    _offsetPx = (_offsetPx + delta).coerceIn(0f, maxOffsetPx)
    return _offsetPx - oldOffset
  }
}