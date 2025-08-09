package com.example.composebasicslab.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val fruits = listOf("Apple", "Banana", "Orange", "Mango", "Peach", "Strawberry", "Grapes")
val names = listOf("Alice", "Bob", "Charlie", "Diana", "Edward", "Fiona")
val tasks = listOf("Buy milk", "Clean the room", "Call mom", "Read a book", "Go for a walk")

@Composable
fun FruitListScreen(){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(  40.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(fruits) { fruit->
            Text(text = fruit)
        }
    }
}

@Composable
fun NameListWithIndex(){
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(40.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        itemsIndexed(names){ index, name ->
            Text(text = "${index + 1}. $name")
        }
    }
}

@Composable
fun TaskListWithIcons(){
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(40.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = tasks){ task ->
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = task)
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "check icon"
                )
            }

        }
    }
}

@Composable
fun AlternatingBackgroundList(){
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(40.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
      itemsIndexed(items = names){ index,name ->
          Text(
              text = "${index + 1}. $name",
              color = if (index % 2 == 0) Color.White else Color.Black,
              modifier = Modifier
                  .fillMaxWidth()
                  .background(
                  color = if (index % 2 == 0) Color.LightGray else Color.White
              )
          )
      }
    }
}

