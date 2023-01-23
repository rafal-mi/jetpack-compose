package org.example.navigation

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home")
    object Detail: Screen(route = "detail_screen?id={id}&name={name}") {
//        fun passId(id: Int = 0): String = "detail_screen?id=$id"

        fun passNameAndId(
            id: Int = 0,
            name: String = "Stevdza-San"
        ) = "detail_screen?id=$id&name=$name"
    }
}
