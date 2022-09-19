import kotlinx.html.HTMLTag

fun HTMLTag.hxGet(value: String) {
    attributes += "hx-get" to value
}
fun HTMLTag.hxSwap(value: String) {
    attributes += "hx-swap" to value
}
fun HTMLTag.hxTarget(value: String) {
    attributes += "hx-target" to value
}
