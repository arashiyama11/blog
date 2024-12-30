package pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import blog.composeapp.generated.resources.Res
import blog.composeapp.generated.resources.androidstudio_dark
import blog.composeapp.generated.resources.compose
import blog.composeapp.generated.resources.css
import blog.composeapp.generated.resources.figma_dark
import blog.composeapp.generated.resources.git
import blog.composeapp.generated.resources.github_dark
import blog.composeapp.generated.resources.githubactions_dark
import blog.composeapp.generated.resources.haskell_dark
import blog.composeapp.generated.resources.html
import blog.composeapp.generated.resources.idea_dark
import blog.composeapp.generated.resources.javascript
import blog.composeapp.generated.resources.kotlin_dark
import blog.composeapp.generated.resources.python_dark
import blog.composeapp.generated.resources.react_dark
import blog.composeapp.generated.resources.rust
import blog.composeapp.generated.resources.tensorflow_dark
import blog.composeapp.generated.resources.typescript
import blog.composeapp.generated.resources.vscode_dark
import org.jetbrains.compose.resources.painterResource

val languages = with(Res.drawable) {
    listOf(kotlin_dark, python_dark, javascript, html, css, haskell_dark)
}

val devTools = with(Res.drawable) {
    listOf(git, github_dark, githubactions_dark, vscode_dark, idea_dark, androidstudio_dark)
}

val interestedIn = with(Res.drawable) {
    listOf(compose, tensorflow_dark, typescript, rust, figma_dark, react_dark)
}

@Composable
fun Index() {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("arashiyama", style = MaterialTheme.typography.h1)
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            "About Me",
            style = MaterialTheme.typography.h3,
            textDecoration = TextDecoration.Underline
        )
        Spacer(Modifier.height(30.dp))
        Text(
            """筑波大学情報学群情報科学類
Kotlinと米津玄師が好き
Androidアプリ開発をメインでやってて、Webフロントエンドエンド、強化学習がほんの少しだけわかる。
暇なときはAtCoderで競技プログラミングしたりバドミントンしてる。
""",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(80.dp))

        Text(
            "Tech Stack",
            style = MaterialTheme.typography.h3,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "触ったことがあるぐらいを意味します",
            color = Color.Gray,
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Text("・Programming languages", style = MaterialTheme.typography.h5)
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyVerticalGrid(
            GridCells.Fixed(6),
            modifier = Modifier.fillMaxWidth().aspectRatio(5f),
            userScrollEnabled = false, horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(languages) {
                Image(
                    painterResource(it),
                    null,
                    modifier = Modifier.fillMaxHeight().heightIn(max = 128.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Text("・Dev tools", style = MaterialTheme.typography.h5)
        }
        Spacer(modifier = Modifier.height(10.dp))

        LazyVerticalGrid(
            GridCells.Fixed(6),
            modifier = Modifier.fillMaxWidth().aspectRatio(5f),
            userScrollEnabled = false,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(devTools) {
                Image(
                    painterResource(it),
                    null,
                    modifier = Modifier.fillMaxHeight().heightIn(max = 128.dp)
                )
            }
        }

        //Image(painterResource(Res.drawable.dev_tools), null, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            "I'm interested in",
            style = MaterialTheme.typography.h3,
            textDecoration = TextDecoration.Underline
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            GridCells.Fixed(6),
            modifier = Modifier.fillMaxWidth().aspectRatio(5f),
            userScrollEnabled = false,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(interestedIn) {
                Image(
                    painterResource(it),
                    null,
                    modifier = Modifier.fillMaxHeight().heightIn(max = 128.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}