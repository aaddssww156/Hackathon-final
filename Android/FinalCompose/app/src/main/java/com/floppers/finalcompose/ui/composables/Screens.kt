package com.floppers.finalcompose.ui.composables

sealed class Screens(val route: String) {
    object SmartScreen: Screens("smart_screen")
    object RegistrationScreen: Screens("registration_screen")
    object LoginScreen: Screens("login_screen")
    object WelcomeScreen: Screens("welcome_screen")
    object RoomsScreen: Screens("rooms_screen")
}
