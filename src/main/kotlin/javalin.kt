import io.javalin.Javalin
import io.javalin.http.staticfiles.Location

fun createJavalin(): Javalin {
    return Javalin.create { config ->
        config.showJavalinBanner = false
        config.addStaticFiles { staticFiles ->
            staticFiles.directory = "static"
            staticFiles.location = Location.CLASSPATH
        }
        config.addStaticFiles { staticFiles ->
            staticFiles.directory = "META-INF/resources/webjars/"
            staticFiles.location = Location.CLASSPATH
        }
    }
}
