package com.retbleed.techbook.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.retbleed.techbook.ui.api.image.ImageViewModel


@OptIn(ExperimentalCoilApi::class)
@Composable
fun MainScreen(navController: NavController, imageViewModel: ImageViewModel) {
    LaunchedEffect(true) {
        imageViewModel.loadImages()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Screen", fontSize = 24.sp)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            imageViewModel.imageList.value?.let { images ->
                val imagesToShow = images.take(6)
                for (image in imagesToShow) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter(data = image.url),
                            contentDescription = image.title,
                            modifier = Modifier.size(60.dp)
                        )
                        Text(
                            text = image.title,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
        Button(onClick = { navController.navigate("login") }) {
            Text(text = "De vuelta a Login")
        }
    }
}
