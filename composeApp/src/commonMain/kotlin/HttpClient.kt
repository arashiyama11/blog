import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import okio.ByteString.Companion.decodeBase64

//TODO　エラーハンドリングやる
expect suspend fun fetch(url: String): String

@Serializable
private data class Links(val self: String, val git: String, val html: String)

@Serializable
private data class Article(
  val name: String,
  val path: String,
  val sha: String,
  val size: Int,
  val url: String,
  val html_url: String,
  val git_url: String,
  val download_url: String,
  val type: String,
  val _links: Links
)

@Serializable
private data class ArticleDetail(val content: String)

private val withUnknownKeys = Json { ignoreUnknownKeys = true }

//記事の名前のリストを返す
suspend fun getArticleNameList(): List<String> {
  val response = fetch("https://api.github.com/repos/arashiyama11/blog/contents/articles")
  val articleJson =
    withUnknownKeys.decodeFromString<@Serializable List<Article>>(response)
  return articleJson.map { it.name }
}

//記事のmarkdownを取得
suspend fun getArticleMd(name: String): String {
  val response =
    withUnknownKeys.decodeFromString<ArticleDetail>(fetch("https://api.github.com/repos/arashiyama11/blog/contents/articles/$name"))
  return response.content.decodeBase64()!!.utf8()
  //TODO エラーハンドリング!!
}