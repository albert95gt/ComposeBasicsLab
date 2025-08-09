package com.example.composebasicslab.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SimpleStarIcon(){
    Icon(
        imageVector = Icons.Default.Star,
        contentDescription = "Icon star",
        tint = Color.Yellow,
        modifier = Modifier.size(64.dp)
    )
}

@Composable
fun HorizontalIconRow(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home icon",
            tint = Color.Blue,
            modifier = Modifier.size(32.dp)
        )

        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Settings icon",
            tint = Color.Green,
            modifier = Modifier.size(32.dp)
        )

        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "Info icon",
            tint = Color.Red,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun ClickableFavoriteIcon(){
    var favoriteState by remember { mutableStateOf(false) }

    IconButton(
        onClick = {
            favoriteState = !favoriteState
        }
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite icon",
            tint = if (favoriteState) Color.Red else Color.Gray
        )
    }

}

@Composable
fun FavoriteIconSelector(){

}

@Composable
fun IconOption(){
    
}
