package ui

import tools.Page
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import tools.onWindowResize
import tools.webWidth
import tools.width

@Composable
fun LayoutBase(
  pageState: MutableState<Page>,
  androidContext: Any? = null,//androidのcontext
  content: @Composable (PaddingValues) -> Unit,
) {
  val headerHeight = 50.dp
  val maxFooterHeight = 300.dp
  val screenWidth = width().dp
  var screenWidthState by remember { mutableStateOf(screenWidth) }
  val wideMode = screenWidth > 800.dp
  var showSidebar by remember { mutableStateOf(wideMode) }
  //webの画面サイズが変わったとき用。androidは画面サイズ変わるとアクティビティがしぬからいらない(多分)
  onWindowResize {
    val width = webWidth()?.dp ?: return@onWindowResize
    val preWidth = screenWidthState
    screenWidthState = width
    if (width < preWidth) showSidebar = width > 800.dp
  }
  val density = LocalDensity.current
  //スクロールないページ,なんとか自動判定できないものか
  val shortPages = setOf(Page.NOT_FOUND)
  val scrollState = remember {
    ConnectionScrollStateImpl(
      maxOffset = maxFooterHeight,
      initialOffset = maxFooterHeight,
      density = density,
    )
  }
  scrollState.offsetPx =
    if (pageState.value in shortPages) 0f else with(density) { maxFooterHeight.toPx() }
  Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
    TopAppBar(modifier = Modifier.height(headerHeight), backgroundColor = Color.Green) {
      Row {
        IconButton(onClick = { showSidebar = !showSidebar }) {
          Icon(
            imageVector = if (showSidebar) Icons.AutoMirrored.Filled.ArrowBack else Icons.Filled.Menu,
            contentDescription = null
          )
        }
      }
    }
  }) {
    if (screenWidthState > 800.dp) Row(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
      AnimatedVisibility(
        showSidebar,
        enter = expandHorizontally(), exit = shrinkHorizontally()
      ) {
        Sidebar(pageState)
      }
      Column(verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxHeight()) {
        Column(
          modifier = Modifier.padding(
            horizontal = max(
              0.dp, min(
                (screenWidthState - 800.dp) / 2, 100.dp
              )
            )
          )
            .border(2.dp, Color.LightGray, shape = RoundedCornerShape(20.dp))
            .nestedScroll(scrollState.nestedScrollConnection)
            .height(tools.height().dp - headerHeight - maxFooterHeight + scrollState.offset)
        ) {
          content(it)
        }
        Footer(
          modifier = Modifier.fillMaxWidth().height(maxFooterHeight - scrollState.offset),
          androidContext
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
          modifier = Modifier.fillMaxWidth().height(maxFooterHeight - scrollState.offset),
          androidContext
        )
      }
      AnimatedVisibility(
        showSidebar, modifier = Modifier.background(color = Color.LightGray),
        enter = expandHorizontally(), exit = shrinkHorizontally()
      ) {
        Sidebar(pageState)
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
  var offsetPx by mutableFloatStateOf(initialOffsetPx)
  val offset: Dp
    get() = with(density) { offsetPx.toDp() }
  
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
    val oldOffset = offsetPx
    offsetPx = (offsetPx + delta).coerceIn(0f, maxOffsetPx)
    return offsetPx - oldOffset
  }
}