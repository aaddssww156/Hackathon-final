package com.floppers.finalcompose.ui.composables

import android.util.Patterns
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.floppers.finalcompose.ui.theme.PrimaryDarkDefault
import com.floppers.finalcompose.ui.theme.PrimaryMainDefault

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("")}
    var isEmailValid by remember { mutableStateOf(false)}

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.size(70.dp))
        Text(text = "Login", modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(150.dp, 30.dp)
            .fillMaxWidth(),
            fontSize = 30.sp)
        
        Spacer(modifier = Modifier.size(100.dp))

        OutlinedTextField(value = email, modifier = Modifier
            .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = PrimaryDarkDefault,
                unfocusedBorderColor = PrimaryMainDefault
            ),
            label = {
                    Text("Email", color = Color.Black)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ), onValueChange = { newEmail ->
                email = newEmail
                isEmailValid = emailChecker(email)
            })

        Spacer(modifier = Modifier.size(30.dp))

        OutlinedTextField(value = password, modifier = Modifier
            .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = PrimaryDarkDefault,
                unfocusedBorderColor = PrimaryMainDefault
            ),
            label = {
                    Text("Password", color = Color.Black)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { newPassword ->
                password = newPassword
            })

        Spacer(modifier = Modifier.size(30.dp))

        Button(onClick = {
            navController.navigate(Screens.RoomsScreen.route)
        }, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth()
            .size(60.dp)
            .padding(50.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryMainDefault),
            shape = RoundedCornerShape(25.dp),
            enabled = isEmailValid) {
            Text(text = "Login!", fontSize = 20.sp)
        }
    }
}

private fun emailChecker(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
