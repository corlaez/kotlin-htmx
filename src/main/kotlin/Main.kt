import friends.addFriendsModule

fun main() {
    val port = 8080
    val javalin = createJavalin()
    javalin.addFriendsModule()
    javalin.start(port)
}
