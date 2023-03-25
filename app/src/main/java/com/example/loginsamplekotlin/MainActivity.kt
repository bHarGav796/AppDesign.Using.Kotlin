package com.example.loginsamplekotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginsamplekotlin.ui.theme.LoginSampleKotlinTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginSampleKotlinTheme {
                //Main Function Starts here
                LoginApplication()
            }
        }
    }
}

@Composable
fun LoginApplication(){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "user_login_page", builder = {
            composable("user_login_page", content = { UserLoginPage(navController = navController) })
            composable("admin_login_page", content = { AdminLoginPage(navController = navController) })
            composable("user_signup_page", content = { UserSignUpPage(navController = navController) })
//            composable("reset_page", content = { ResetPage(navController = navController) })
        })
    }

