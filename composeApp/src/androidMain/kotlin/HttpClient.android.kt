import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import java.nio.charset.Charset

actual suspend fun fetch(url: String): String {
  println("start")
  val cn = URL(url)
  return withContext(Dispatchers.IO) {
    cn.openStream()
  }.readBytes().toString(Charset.defaultCharset())
}