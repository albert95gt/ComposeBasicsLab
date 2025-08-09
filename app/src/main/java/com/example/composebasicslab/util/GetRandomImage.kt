package com.example.composebasicslab.util

import android.media.Image

fun getRandomImage(): String {
    val imageUrl = "https://picsum.photos/id/"

    val randomNumber = (250..280).random().toString()
    return "$imageUrl/${randomNumber}/120/200"
}