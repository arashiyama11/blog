package ui

import tools.Page
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.calculatePan
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import blog.composeapp.generated.resources.Res
import blog.composeapp.generated.resources.dark_mode
import blog.composeapp.generated.resources.light_mode
import org.jetbrains.compose.resources.painterResource
import tools.onWindowResize
import tools.webWidth
import tools.width

@Composable
fun LayoutBase(
    onPageChange: (Page) -> Unit,
    isDarkTheme: Boolean,
    toggleDarkTheme: () -> Unit,
    content: @Composable () -> Unit,
) {
    val headerHeight = 50.dp
    val screenWidth = width().dp
    var screenWidthState by remember { mutableStateOf(screenWidth) }
    val wideMode = screenWidth > 800.dp
    var showSidebar by remember { mutableStateOf(wideMode) }
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        onWindowResize {
            val width = webWidth()?.dp ?: return@onWindowResize
            val preWidth = screenWidthState
            screenWidthState = width
            if (width < preWidth && width <= 800.dp) showSidebar = false
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize().pointerInput(Unit) {
        awaitEachGesture {
            var dx = 0f
            var start = true
            var doOpen = true
            do {
                val event = awaitPointerEvent()
                dx += event.calculatePan().x
                if (start) {
                    start = false
                    if (event.changes[0].position.x > 100) {
                        doOpen = false
                    }
                }
            } while (event.changes.any { it.pressed })
            if (dx > 100 && doOpen) {
                showSidebar = true
            } else if (dx < -100) {
                showSidebar = false
            }
        }
    }, topBar = {
        TopAppBar(
            modifier = Modifier.height(headerHeight).border(
                1.dp, MaterialTheme.colors.onBackground
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { showSidebar = !showSidebar }) {
                    Icon(
                        imageVector = if (showSidebar) Icons.AutoMirrored.Filled.ArrowBack else Icons.Filled.Menu,
                        contentDescription = null
                    )
                }
                IconButton(onClick = toggleDarkTheme) {
                    Icon(
                        painterResource(if (isDarkTheme) Res.drawable.light_mode else Res.drawable.dark_mode),
                        null
                    )
                }
            }
        }
    }) { paddingValues ->
        if (screenWidthState > 800.dp) Row(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            AnimatedVisibility(
                showSidebar,
                enter = expandHorizontally(), exit = shrinkHorizontally()
            ) {
                Sidebar(onPageChange)
            }
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxHeight().verticalScroll(scrollState)
            ) {
                Box(
                    Modifier.padding(
                        horizontal = max(
                            0.dp, min(screenWidthState / 4 - 200.dp, screenWidthState / 2 - 550.dp)
                        ), vertical = 8.dp
                    )
                        .background(MaterialTheme.colors.surface).border(
                            2.dp,
                            MaterialTheme.colors.onBackground,
                            shape = RoundedCornerShape(20.dp)
                        ).fillMaxSize()
                        .heightIn(min = tools.height().dp - 300.dp - paddingValues.calculateTopPadding())
                        .padding(vertical = 16.dp, horizontal = 32.dp)
                ) {
                    content()
                }
                Footer(
                    modifier = Modifier.fillMaxWidth().height(300.dp)
                )
            }
        }
        else Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxHeight().verticalScroll(scrollState)
            ) {
                Box(
                    Modifier.padding(8.dp).background(MaterialTheme.colors.surface)
                        .border(
                            2.dp,
                            MaterialTheme.colors.onBackground,
                            shape = RoundedCornerShape(20.dp)
                        ).padding(vertical = 16.dp, horizontal = 16.dp)
                ) {
                    content()
                }
                Footer(
                    modifier = Modifier.fillMaxWidth().height(300.dp).padding(horizontal = 8.dp)
                )
            }
            AnimatedVisibility(
                showSidebar, modifier = Modifier.background(color = Color.LightGray),
                enter = expandHorizontally(), exit = shrinkHorizontally()
            ) {
                Sidebar(onPageChange)
            }
        }
    }
}