package com.example.composebasicslab.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
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
fun SimpleButtonExample(){
    var ClickedBtnText by remember { mutableStateOf("Click the button") }

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                ClickedBtnText = "Button has clicked"
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Button")
        }

        Text(
            text = ClickedBtnText,
            color = Color.White
        )
    }
}

@Composable
fun TwoButtonColumn(){
    Column {
        Button(onClick = {}) {
            Text(text = "Mentés")
        }

        OutlinedButton(onClick = {}) {
            Text(text = "Mégse")
        }
    }

}

@Composable
fun ButtonRowExample(){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Button(onClick = {}) {
            Text(text = "OK")
        }

        OutlinedButton(onClick = {}) {
            Text(text = "Mégse")
        }

        TextButton(onClick = {}) {
            Text(text = "Segítség")
        }
    }
}

@Composable
fun FavoriteIconButton(){
    IconButton(onClick = {
        Log.d("FavoriteButton", "Kedvenchez adva")
    }) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorites",
            tint = Color.Red
            )
    }
}

@Composable
fun DisabledButtonExample(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Ez a funkció még nem elérhető")
        Button(
            onClick = {},
            enabled = false
        ) {
            Text("Nem elérhető")
        }
    }
}

@Composable
fun FloatingActionButtonExample(){
    FloatingActionButton(
        onClick = {
            Log.d("FloatingButton", "Új elem hozzáadva")
        }
    ){
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
        )
    }
}