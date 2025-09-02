package com.example.composebasicslab.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SimpleSlider() {
    var sliderValue by remember { mutableStateOf(0f) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(text = "Érték ${(sliderValue * 100).toInt()} %")

        Slider(
            value = sliderValue,
            onValueChange = { newValue ->
                sliderValue = newValue
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun SliderWithSteps() {
    var sliderValue by remember { mutableStateOf(1f) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(text = "Nehézségi szint: ${sliderValue.toInt()}")
        Slider(
            value = sliderValue,
            onValueChange = { newValue ->
                sliderValue = newValue
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            valueRange = 1f .. 5f,
            steps = 3
        )
    }
}

@Composable
fun VolumeSlider() {
    var sliderValue by remember { mutableFloatStateOf(0f) }
    var sliderIsActive by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Volume: ${sliderValue.toInt()} %")
        Spacer(modifier = Modifier.height(10.dp))
        Checkbox(
            checked = sliderIsActive,
            onCheckedChange = {sliderIsActive = !sliderIsActive}
        )
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f .. 100f,
            enabled = sliderIsActive,
            colors = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTickColor = Color.Green,
                inactiveTickColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}