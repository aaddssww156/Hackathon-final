package com.floppers.finalcompose.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.floppers.finalcompose.ui.theme.*



@Composable
fun WelcomeScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Welcome!",
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            //.size(100.dp)
            .padding(120.dp, 100.dp)
            .fillMaxWidth(),
        fontSize = 30.sp)
        Spacer(modifier = Modifier.padding(30.dp))
        Button(onClick = {
            navController.navigate(Screens.RegistrationScreen.route)
        }, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth()
            .size(60.dp)
            .padding(50.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryMainDefault),
            shape = RoundedCornerShape(25.dp)){
            Text(text = "Register", fontSize = 20.sp)
        }
        
        Spacer(modifier = Modifier.size(30.dp))
        
        Button(onClick = {
            navController.navigate(Screens.LoginScreen.route)
        }, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth()
            .size(60.dp)
            .padding(50.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryMainDefault),
            shape = RoundedCornerShape(25.dp)){
            Text(text = "Login", fontSize = 20.sp)
        }
    }
}