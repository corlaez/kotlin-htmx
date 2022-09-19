import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun htmlBaseTemplate(bodyFn: BODY.() -> Unit): String {
    return "<!DOCTYPE html>" + createHTML().html {
        lang = "en"
        head {
            script { src = "htmx.js" }
            link { href = "/styles.css"; rel="stylesheet" }
        }
        body {
            bodyFn()
            br()
            a {
                href = "https://corlaez.com/blog/kotlin-htmx.html"
                +"Go to related blog post in corlaez.com"
            }
        }
    }
}
