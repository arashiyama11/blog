package pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import blog.composeapp.generated.resources.langs
import blog.composeapp.generated.resources.dev_tools
import blog.composeapp.generated.resources.ints
import org.jetbrains.compose.resources.painterResource

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
            """筑波大学に通っている人
Kotlinと米津玄師が好き
Web開発,Androidアプリ開発あたりを少しやっています。
暇なときはAtCoderで競技プログラミングしたり、機械学習周り触ってます。
あとバドミントンやってます。""",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(100.dp))

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

        Image(painterResource(Res.drawable.langs), null)
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Text("・Dev tools", style = MaterialTheme.typography.h5)
        }
        Spacer(modifier = Modifier.height(10.dp))

        Image(painterResource(Res.drawable.dev_tools), null, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "I'm interested in",
            style = MaterialTheme.typography.h3,
            textDecoration = TextDecoration.Underline
        )

        Spacer(modifier = Modifier.height(20.dp))

        Image(painterResource(Res.drawable.ints), null, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))
    }
}