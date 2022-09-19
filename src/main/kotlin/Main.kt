import friends.addFriendsModule
import io.javalin.Javalin
import io.javalin.http.staticfiles.Location

const val isDev = true

fun main() {
    deleteDirectory("output")
    createDirectory("output")
    saveFileFromResource("/static/modest-variation.css", "output/", "styles.css")
    saveFileFromResource("/META-INF/resources/webjars/htmx.org/$htmxVersion/dist/htmx.js", "output/", "htmx.js")
    addFriendsModule()
    if (isDev) previewServer()
}

fun previewServer() {
    Javalin.create { config ->
        config.showJavalinBanner = false
        config.addStaticFiles { staticFiles ->
            staticFiles.directory = "output"
            staticFiles.location = Location.EXTERNAL
        }
    }.start(8081)
}
