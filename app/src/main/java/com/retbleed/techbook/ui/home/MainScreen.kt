package com.retbleed.techbook.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import com.retbleed.techbook.ui.components.ImageCard
import com.retbleed.techbook.utils.api.image.ImageViewModel


@OptIn(ExperimentalCoilApi::class)
@Composable
fun MainScreen(navController: NavController, viewModel: ImageViewModel) {
    val images by remember { viewModel.images }

    LaunchedEffect(Unit) {
        viewModel.loadAndInsertData()
    }

    LazyColumn() {
        items(items = images) { image ->
            ImageCard(image)
        }
    }
}