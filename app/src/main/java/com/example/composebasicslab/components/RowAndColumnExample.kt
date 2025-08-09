package com.example.composebasicslab.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalTextRow(){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "Hello")

        Text(text = "Jetpack")

        Text(text = "Compose")
    }
}

@Composable
fun IconWithTextRow(){
    Row (
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite icon",
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "Favorite")
    }
}

@Composable
fun ButtonRow(){
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Button(onClick = {}) {
            Text(text = "Yes")
        }

        Button(onClick = {}) {
            Text(text = "No")
        }

        Button(onClick = {}) {
            Text(text = "Maybe")
        }

    }
}

@Composable
fun VerticalTextColumn(){
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Android",
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = "Jetpack",
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = "Compose",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun TextWithButtonColumn(){
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Do you need know more?")

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {}) {
            Text(text = "Click here")
        }
    }
}

@Composable
fun VerticalIconsColumn(){
    Column (
        modifier = Modifier.height(200.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home"
        )
        Spacer(modifier = Modifier.height(24.dp))

        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Settings"
        )
        Spacer(modifier = Modifier.height(24.dp))

        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite"
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}