package com.example.composebasicslab.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

val options = listOf("Piros", "Zöld", "Kék")
@Composable
fun SimpleDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Válassz egy elemet") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)

    ){
        Button(
            onClick = {
                expanded = !expanded
            }
        ) {
            Text(text = selectedOption)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(text = "Első") },
                onClick = {
                    selectedOption = "Első"
                    expanded = false
                }
            )

            DropdownMenuItem(
                text = { Text(text = "Második") },
                onClick = {
                    selectedOption = "Második"
                    expanded = false
                }
            )

            DropdownMenuItem(
                text = { Text(text = "Harmadik") },
                onClick = {
                    selectedOption = "Harmadik"
                    expanded = false
                }
            )
        }
    }
}

@Composable
fun DynamicDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Válassz egy szint") }

    var buttonTextColor =
        when(selectedOption){
            "Piros" -> Color.Red
            "Zöld" -> Color.Green
            "Kék" -> Color.Blue
            else -> Color.White
        }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)

    ){
        Button(
            onClick = {
                expanded = !expanded
            }
        ) {
            Text(
                text = selectedOption,
                color = buttonTextColor
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                val color = when(option) {
                    "Piros" -> Color.Red
                    "Zöld" -> Color.Green
                    "Kék" -> Color.Blue
                    else -> Color.Black
                }

                DropdownMenuItem(
                    text = {
                        Row {
                            Text(
                                text = option,
                                color = color,
                                modifier = Modifier.weight(0.9f)
                            )
                        }
                    },
                    onClick = {
                        selectedOption = option
                        expanded = false
                    }
                )
             }
        }
    }
}