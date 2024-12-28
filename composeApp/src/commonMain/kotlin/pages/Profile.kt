package pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import kotlinx.datetime.yearsUntil
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Profile() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Profile", style = MaterialTheme.typography.h1,
            textDecoration = TextDecoration.Underline
        )
        Spacer(Modifier.height(50.dp))
        profileElem("Handle name", "arashiyama or kamu")
        val birthday = LocalDate.parse("2006-02-11")
        val age = birthday.yearsUntil(Clock.System.todayIn(TimeZone.UTC))
        profileElem("Age", age.toString())
        profileElem("Birthday", "Feb 11, 2006")
        profileElem("School", "University of Tsukuba,\nCollege of Information Science")
        profileElem("Live in", "Tukuba City, Ibaraki, Japan")
        profileElem("From", "Yokohama City, Kanagawa, Japan")
        Spacer(Modifier.height(50.dp))
        Text(
            "Tech Stack",
            style = MaterialTheme.typography.h3,
            textDecoration = TextDecoration.Underline
        )

        techStackElem(
            "JavaScript",
            "一通りかけるけどUI操作は苦手。Reactあたりのフレームワークまともに使ったことないのでいつか使いたいと思ってる。手元の計算機とか簡単なツールは大体Node.jsで書いてる"
        )
        techStackElem("HTML,CSS", "わかんないことはわかる")
        techStackElem(
            "GoogleAppsScript",
            "割とわかる。定期実行したいツールの作成はコレ。マジ便利。一時期ココナラで小銭稼ぎしてた"
        )
        techStackElem(
            "Kotlin",
            "一番好き。素直でクセがなくて書いてて気持ちいい。全てをKotlinで書きたいと思っている"
        )
        techStackElem("Android dev", "わかんないけど、理解したい。Androidアプリを作る構想はある")
        techStackElem(
            "Jetpack Compose",
            "Multiplatform含めて結構触ってる。ModifierはCSSより素直な感じがして良い。Compose Multiplatformでこのページ書いてる。書き心地良いしDesktopツール作るならコレ使おうと思ってる"
        )
        techStackElem(
            "Python",
            "競プロと機械学習専用言語。あんま好きじゃない。再代入禁止ぐらいさせてほしい"
        )

        techStackElem(
            "Haskell",
            "マジでわからん。高校2年生当時、関数型言語とやらに興味を持つが、2,3ヶ月で挫折。とはいえ副作用や参照透過性,遅延評価の考え方と向き合えていい経験になったと思っている"
        )

        techStackElem("Git", "すこしわかる")
        techStackElem(
            "GitHub",
            "よくわかんないままActionsとか書いてる。多分このサービスの10%ぐらいは使えてる"
        )
    }
    Spacer(modifier = Modifier.height(50.dp))
}

@Composable
fun profileElem(a: String, b: String) = Row(modifier = Modifier.fillMaxWidth()) {
    Text(a.padEnd(20), modifier = Modifier.width(160.dp), style = MaterialTheme.typography.body1)
    Text(b, style = MaterialTheme.typography.body2)
    Spacer(Modifier.height(30.dp))
}


@Composable
fun techStackElem(name: String, content: String) =
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("- ", style = MaterialTheme.typography.body1)
            Text(
                name,
                style = MaterialTheme.typography.body1,
                textDecoration = TextDecoration.Underline
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                content,
                style = MaterialTheme.typography.body2
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
    }

