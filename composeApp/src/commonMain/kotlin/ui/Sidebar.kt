package ui

import tools.Page
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Sidebar(onPageChange: (Page) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight()
            .background(color = MaterialTheme.colors.secondary).width(300.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp),
        contentPadding = PaddingValues(end = 6.dp)
    ) {
        item { sidebarLink("Home", { onPageChange(Page.INDEX) }) { Icon(Icons.Filled.Home, null) } }
        item {
            sidebarLink(
                "Profile",
                { onPageChange(Page.PROFILE) }) { Icon(Icons.Filled.Person, null) }
        }
        //item { sidebarLink("Portfolio") { changePage(pageState, Page.PORTFOLIO) } }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun sidebarLink(text: String, onClick: () -> Unit, icon: (@Composable () -> Unit)?) =
    ListItem(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick).height(50.dp)
            .wrapContentSize(),
        icon = icon
    ) {
        Text(text, style = MaterialTheme.typography.h6)
    }