package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import blog.composeapp.generated.resources.XMark
import blog.composeapp.generated.resources.Res
import blog.composeapp.generated.resources.compose_multiplatform
import blog.composeapp.generated.resources.github_dark
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource
import tools.JumpExternalPage
import tools.kmpLocalContext

@Composable
fun Footer(modifier: Modifier) = Column(modifier = modifier.fillMaxSize()) {
    val jumpExternalPage = JumpExternalPage(kmpLocalContext())
    val year = remember { Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).year }
    Row(
        modifier = Modifier.fillMaxWidth().height(200.dp)
            .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(20.dp))
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onBackground,
                shape = RoundedCornerShape(20.dp)
            ).padding(vertical = 8.dp, horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight().weight(24f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(" Links", style = MaterialTheme.typography.h3)
            ExPageLink("X Account", { Icon(painterResource(Res.drawable.XMark), null) }) {
                jumpExternalPage("https://x.com/kamu_coins")
            }
            ExPageLink(
                "GitHub Profile",
                { Image(painterResource(Res.drawable.github_dark), null) }
            ) { jumpExternalPage("https://github.com/arashiyama11") }
            ExPageLink(
                "This Site's Repository",
                { Image(painterResource(Res.drawable.github_dark), null) }
            ) { jumpExternalPage("https://github.com/arashiyama11/blog") }
        }
        Spacer(modifier = Modifier.fillMaxHeight().weight(2f))
        Column(
            modifier = Modifier.fillMaxHeight().weight(24f),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                " Contact",
                style = MaterialTheme.typography.h3
            )

            ExPageLink("X Direct Message",
                { Icon(painterResource(Res.drawable.XMark), null) }
            ) {
                jumpExternalPage("https://x.com/kamu_coins")
            }
            ExPageLink("arashiyama${1120}@gmail.com",
                { Icon(Icons.Default.Email, null) }
            ) {}
        }
    }
    //コピーライト
    Column(
        modifier = Modifier.fillMaxSize().height(100.dp)
            .background(MaterialTheme.colors.surface, shape = RoundedCornerShape(20.dp))
            .border(1.dp, MaterialTheme.colors.onBackground, shape = RoundedCornerShape(20.dp))
            .padding(8.dp)
    ) {
        Text(
            "Copyright © $year arashiyama All Rights Reserved",
            modifier = Modifier.fillMaxWidth().wrapContentSize().weight(1f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
        )
        Row(
            modifier = Modifier.fillMaxWidth().wrapContentWidth().weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Powered by Compose Multiplatform",
                modifier = Modifier,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6,
            )
            Image(
                painterResource(Res.drawable.compose_multiplatform),
                "compose_multiplatform",
                modifier = Modifier.size(with(
                    LocalDensity.current
                ) { 20.sp.toDp() }).background(Color.White, CircleShape)
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ExPageLink(text: String, icon: @Composable () -> Unit, onClick: () -> Unit) =
    ListItem(
        modifier = Modifier.fillMaxWidth().height(42.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onBackground,
                shape = RoundedCornerShape(6.dp)
            )
            .clickable { onClick() }.clip(RoundedCornerShape(6.dp)),
        icon = icon
    ) {
        Text(
            text,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight.ExtraBold,
        )
    }