import org.w3c.xhr.XMLHttpRequest
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

actual suspend fun fetch(url: String) = suspendCoroutine { con ->
  val req = XMLHttpRequest()
  req.open("GET", url, true)
  req.onload = {
    val res = req.response.toString()
    con.resume(res)
  }
  req.send("")
}
