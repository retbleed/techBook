package com.retbleed.techbook.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.retbleed.techbook.ui.api.image.ImageViewModel
import com.retbleed.techbook.ui.home.MainScreen
import com.retbleed.techbook.ui.init.LoginScreen
import com.retbleed.techbook.ui.init.SplashScreenContent
import com.retbleed.techbook.ui.theme.TechbookTheme

class MainActivity : ComponentActivity() {
    private val imageViewModel = ImageViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TechbookTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash"){
                    composable("splash"){ SplashScreenContent(navController = navController) }
                    composable("login"){ LoginScreen(navController)}
                    composable("home"){ MainScreen(navController, imageViewModel)}
                }
            }
        }
    }
}