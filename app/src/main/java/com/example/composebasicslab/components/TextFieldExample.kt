package com.example.composebasicslab.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NameInputField_TextField(){
    var text by remember { mutableStateOf("") }

    Column {
        TextField(
            value = text,
            onValueChange = {text = it},
            label = {
                Text("Your name:")
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Text(
            text= "Hello $text",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun NameInputField_Outlined(){
    var text by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = {
                Text("Your name:")
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Text(
            text= "Hello $text",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun CommentBox(){
    var text by remember { mutableStateOf("") }

    Column (modifier = Modifier.padding(50.dp))
    {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text(text= "Your comment:")
            },
            maxLines = 5,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (text.length < 100) "Karakterek száma: ${text.length}" else "Túl sok szöveg!",
            color = if (text.length < 100) Color.White else Color.Red
        )
    }
}

@Composable
fun SearchBarWithFilter(){
    var query by remember { mutableStateOf("") }
    val fruits = listOf("Apple", "Banana", "Cherry", "Grapes", "Kiwi")

    Column {
        TextField(
            value = query,
            onValueChange = {query = it}
        )
        Spacer(modifier = Modifier.height(20.dp))
        val filteredFruits = fruits.filter { it.contains(query, ignoreCase = true) }

        val result = filteredFruits.mapIndexed { index, fruit -> "$index.$fruit" }
        val displayedText = result.joinToString("\n")

        Text(text = displayedText)

    }
}

