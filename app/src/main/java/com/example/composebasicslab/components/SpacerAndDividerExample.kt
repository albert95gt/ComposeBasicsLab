package com.example.composebasicslab.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun TextSpacerColumn(){
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(text = "Header")
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Main content")
    }
}

@Composable
fun IconSpacerRow(){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Star icon"
        )

        Spacer(modifier = Modifier.width(16.dp))

        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite icon"
        )
    }
}

@Composable
fun CenteredButtonWithSpacer(){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(onClick = {}) {
            Text(text = "Click here")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Thank you!")
    }
}

@Composable
fun TextWithDivider(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Text(text = "Header")
        HorizontalDivider(
            thickness = 2.dp,
            color = Color.LightGray
        )
        Text(text = "Main content")
    }
}

@Composable
fun ButtonDividerColumn(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Button(onClick = {}) {
            Text(text = "First")
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = Color.LightGray
        )

        Button(onClick = {}) {
            Text(text = "Second")
        }
    }
}

@Composable
fun ImageWithBottomDivider(){
    val imageUrl = "https://picsum.photos/249"
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .build(),
            contentDescription = "Random image from picsum",
            modifier = Modifier.size(300.dp)
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
        )
    }
}