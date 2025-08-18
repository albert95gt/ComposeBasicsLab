package com.example.composebasicslab.components

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleCounter() {
    var counterState by remember { mutableStateOf(0) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Text(
            text = "Counter: ${counterState.toString()}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = { counterState += 1}
        ) {
            Text(text = "Counter + 1")
        }
    }
}

@Composable
fun ToggleButton() {
    var buttonState by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Text(
            text = if (buttonState) "Button is on" else "Button is off",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Button(
            onClick = {buttonState = !buttonState}
        ) {
            Text(
                text = if (!buttonState) "Button on" else "Button off"
            )
        }
    }
}

@Composable
fun LivePreviewText() {
    var inputState by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){
        TextField(
            value = inputState,
            onValueChange = { newText ->
                if (newText.length <= 20) {
                    inputState = newText
                }
            },
            label = {Text(text = "Max 20 character")},
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = "Remaining: ${20 - inputState.length} characters"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Preview: $inputState"
        )
    }
}