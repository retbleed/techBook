package com.retbleed.techbook.ui.init
import com.retbleed.techbook.R

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.retbleed.techbook.ui.theme.TechbookTheme

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TechbookTheme {
                val navController = rememberNavController()
                SplashScreenContent(navController = navController)
            }
        }
    }
}

@Composable
fun SplashScreenContent(navController: NavController) {
    var isAnimationFinished by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        if (!isAnimationFinished) {
            LaunchedEffect(Unit) {
                kotlinx.coroutines.delay(10000)
                isAnimationFinished = true
                navController.navigate("login")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.github),
                    contentDescription = "Github Logo",
                )
                Spacer(modifier = Modifier.height(50.dp))
                CircularProgressIndicator(color = Color.Black)
            }
        }
    }
}
