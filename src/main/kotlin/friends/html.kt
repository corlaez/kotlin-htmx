package friends

import htmlBaseTemplate
import hxGet
import hxSwap
import hxTarget
import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun htmlFriendsIndex(friends: List<String>): String {
    return htmlBaseTemplate {
        h1 { a { href = "/"; +"My Friends" } }
        friends.forEach { friend ->
            h2 {
                a {
                    href = "/$friend"// Sets cursor pointer and works without js
                    hxGet("/$friend")
                    hxSwap("outerHTML")
                    hxTarget("closest h2")
                    +friend
                }
            }
        }
    }
}

fun htmlFriendProfile(friend: String, characteristic: String): String {
    return createHTML().article {
        h2(classes = "your-css-class") {
            +friend
        }
        p {
            +"My friend $friend is smart and a good $characteristic"
        }
    }
}
