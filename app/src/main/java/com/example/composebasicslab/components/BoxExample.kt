package com.example.composebasicslab.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun LayeredTextBox(){
    Box (
        modifier = Modifier
            .size(150.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Háttér",
            color = Color.Yellow
        )

        Text(
            text = "Előtér",
            color = Color.White
        )
    }
}

@Composable
fun ImageWithBottomTextBox(){
    val imageUrl = "https://picsum.photos/249"
    Box(
        modifier = Modifier.size(300.dp),
        contentAlignment = Alignment.Center
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .build(),
            contentDescription = "Random image from picsum",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )

        Text(
            text = "Image description",
            color = Color.Yellow,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

@Composable
fun FloatingButtonBox(){
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(Color.LightGray)
    ){
        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
        ) {
            Text(text = "OK")
        }
    }
}