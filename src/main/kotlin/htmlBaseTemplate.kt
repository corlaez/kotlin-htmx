import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun htmlBaseTemplate(bodyFn: BODY.() -> Unit): String {
    return "<!DOCTYPE html>" + createHTML().html {
        lang = "en"
        head {
            script { src = "/htmx.org/$htmxVersion/dist/htmx.js" }
            link { href = "/modest-variation.css"; rel="stylesheet" }
        }
        body {
            bodyFn()
        }
    }
}
