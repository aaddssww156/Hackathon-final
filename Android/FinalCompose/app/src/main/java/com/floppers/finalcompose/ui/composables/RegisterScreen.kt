package com.floppers.finalcompose.ui.composables

import android.util.Patterns
import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.floppers.finalcompose.data.NewUser
import com.floppers.finalcompose.data.RetrofitApi
import com.floppers.finalcompose.data.RetrofitHelper
import com.floppers.finalcompose.ui.theme.PrimaryDarkDefault
import com.floppers.finalcompose.ui.theme.PrimaryMainDefault
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.regex.Pattern

@Composable
fun RegisterScreen(navController: NavController) {

    var email by remember { mutableStateOf("")}
    var name by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var repPassword by remember { mutableStateOf("")}
    
    var isEmailValid by remember { mutableStateOf(false)}
    var isPasswordValid by remember { mutableStateOf(false)}

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.size(70.dp))
        Text(text = "Register", modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(130.dp, 30.dp)
            .fillMaxWidth(),
        fontSize = 30.sp)

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
            ), onValueChange = { newEmail->
                email = newEmail
                isEmailValid = emailChecker(email)
        })

        Spacer(modifier = Modifier.size(30.dp))

        OutlinedTextField(value = name, modifier = Modifier
            .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = PrimaryDarkDefault,
                unfocusedBorderColor = PrimaryMainDefault
            ),
            label = {
                    Text("Name", color = Color.Black)
            }, onValueChange = { newName ->
                name = newName
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
                    Text(text = "Password", color = Color.Black)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { newPassword ->
                password = newPassword
            })

        Spacer(modifier = Modifier.size(30.dp))

        OutlinedTextField(value = repPassword, modifier = Modifier
            .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = PrimaryDarkDefault,
                unfocusedBorderColor = PrimaryMainDefault
            ),
            label = {
                    Text("Password again", color = Color.Black)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { newRepPassword ->
                repPassword = newRepPassword
                isPasswordValid = passwordChecker(password, repPassword)
            })

        Spacer(modifier = Modifier.size(30.dp))

        Button(onClick = {
            //registerNew(name, email, password, repPassword)
            navController.navigate(Screens.RoomsScreen.route)
        }, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth()
            .size(60.dp)
            .padding(50.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryMainDefault),
        shape = RoundedCornerShape(25.dp),
        enabled = isEmailValid && isPasswordValid) {
            Text(text = "Register!", fontSize = 20.sp)
        }

    }

}

private fun emailChecker(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

private fun passwordChecker(password: String, repPassword: String): Boolean = (password.length >= 5) && (repPassword.length >= 5) && (password == repPassword)

private fun registerNew(username: String, email: String, password1: String, password2: String) {
    val retrofitApi = RetrofitHelper.getInstance().create(RetrofitApi::class.java)
    val user = NewUser(username, email, password1, password2)
    GlobalScope.launch {
        retrofitApi.postNewUser(user)
    }
}