package tools

import kotlinx.browser.window

actual fun rewriteWebPagePath(page: Page, newPage: Page) {
    if (page == newPage) return
    val (title, pagePath) = when (newPage) {
        Page.INDEX -> "home" to "index"
        Page.PROFILE -> "profile" to "profile"
        Page.PORTFOLIO -> "profile" to "portfolio"
        Page.NOT_FOUND -> "Not Found" to "not_found"
    }
    window.history.pushState(
        null,
        title,
        "${window.location.origin}${window.location.pathname}?page=$pagePath"
    )
}