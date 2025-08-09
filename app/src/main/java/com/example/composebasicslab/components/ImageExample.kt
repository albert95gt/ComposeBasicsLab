package com.example.composebasicslab.components

import  com.example.composebasicslab.R
import android.graphics.ColorMatrix
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun BasicAsyncImage(){
    val imageUrl = "https://picsum.photos/250/300"

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .build(),
        contentDescription = "Some image from internet",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Composable
fun RoundedImageWithBorder(){
    val imageUrl = "https://picsum.photos/249"

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .build(),
        contentDescription = "Image with border",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .border(
                width = 4.dp,
                color = Color.Green,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))

    )
}

@Composable
fun ImageWithOverlayText(){
    val imageUrl = "https://picsum.photos/249"

    Box(
        modifier = Modifier
            .size(250.dp)
            .clip(RoundedCornerShape(12.dp))
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .build(),
            contentDescription = "Image with overlay",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .background(color = Color.Black.copy(alpha = 0.4f))
                .padding(8.dp),
            contentAlignment = Alignment.TopCenter
        ){
            Text(
                text = "Overlay image text",
                color = Color.White.copy(alpha = 0.6f)
            )
        }
    }
}

@Composable
fun ImageWithCircleShapeAndShadow(){
    val imageUrl = "https://picsum.photos/300"

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .build(),
        contentDescription = "Profile image with shadow",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(180.dp)
            .graphicsLayer {
                shadowElevation = 40f
                shape = CircleShape
                clip = true
            }
            .clip(shape = CircleShape)
            .border(
                width = 2.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
    )
}

@Composable
fun ImageWithErrorAndPlaceholder(){
    val imageUrl = "https://picsum.photos/-300"

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = "Error image",
        contentScale = ContentScale.Crop,
        placeholder = painterResource(R.drawable.placeholder),
        error = painterResource(R.drawable.error),
        modifier = Modifier.size(180.dp)

    )
}