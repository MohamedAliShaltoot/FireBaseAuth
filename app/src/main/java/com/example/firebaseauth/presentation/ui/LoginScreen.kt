package com.example.firebaseauth.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.firebaseauth.presentation.viewModel.AuthViewModel

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        val email= remember { mutableStateOf("") }
        val password= remember { mutableStateOf("") }
        val navigator = LocalNavigator.currentOrThrow
        val viewmodel= AuthViewModel()
        val errormessage= remember {
            mutableStateOf("")
        }
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(placeholder = {
                Text(text = "Email")
            },value = email.value, onValueChange = {
                email.value=it
            })
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(supportingText = {
                                               Text(text = "Password should have at least 8 characters")
            },isError = true,placeholder = {
                Text(text = "Password")
            },value = password.value, onValueChange = {
                password.value=it
            })
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                viewmodel.login(email.value,password.value, onSucess = {navigator.push(HomeScreen())}, onFailure = {

                })
               // navigator.pop()
            //navigator.push(HomeScreen())
            }) {
              Text(text = " Login ")
            }

            Spacer(modifier = Modifier.height(10.dp))
            TextButton(onClick = {

                navigator.push(RegisterScreen()) }) {
              Text(text = "Don't hava an account ? Register")  
            }

        }
    }
}