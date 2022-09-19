package friends

import io.javalin.Javalin

fun Javalin.addFriendsModule() {
    val friends = listOf("Joseph", "Nicholas", "Caesar")
    get("/") { ctx ->
        ctx.html(htmlFriendsIndex(friends))
    }
    friends.forEach { friend ->
        get("/$friend") { ctx ->
            val characteristic = listOf("swimmer", "runner", "debater").random()
            ctx.html(htmlFriendProfile(friend, characteristic))
        }
    }
}
