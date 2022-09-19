package friends

import saveFile

fun addFriendsModule() {
    val friends = listOf("Joseph", "Nicholas", "Caesar")
    saveFile(htmlFriendsIndex(friends), "output/", "index.html")
    friends.zip(listOf("swimmer", "runner", "debater")).forEach { (friend, characteristic) ->
        saveFile(htmlFriendProfile(friend, characteristic), "output/", "$friend.html")
    }
}
