package com.floppers.finalcompose.ui.composables

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation1() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.WelcomeScreen.route) {
        composable(route = Screens.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screens.RegistrationScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screens.SmartScreen.route) {
            SmartScreen(navController = navController)
        }
        composable(route = Screens.RoomsScreen.route) {
            RoomsScreen(navController = navController)
        }
    }
}