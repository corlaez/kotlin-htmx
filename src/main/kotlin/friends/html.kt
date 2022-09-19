package friends

import htmlBaseTemplate
import hxGet
import hxSwap
import hxTarget
import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun htmlFriendsIndex(friends: List<String>): String {
    return htmlBaseTemplate { /* inside the block `this` is a BODY HTML instance */
        h1 { a { href = "index.html"; +"My Friends" } }// nested `a` inside a `h1`. To insert a text inside any tag we use the + operator
        friends.forEach { friend ->
            h2 {
                a {
                    href = "$friend.html"// Sets cursor pointer and works without js
                    hxGet("$friend.html")
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
