package com.example.composebasicslab.util

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

fun randomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f
    )
}

val predefinedColorList = listOf(
    Color.Red, Color.Green, Color.Blue,
    Color.Yellow, Color.Cyan, Color.Magenta
)

fun getRandomPredefinedColor(): Color {
    return predefinedColorList.random()
}