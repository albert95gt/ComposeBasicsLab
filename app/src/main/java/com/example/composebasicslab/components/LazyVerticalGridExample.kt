package com.example.composebasicslab.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composebasicslab.util.randomColor

@Composable
fun SimpleGrid() {
    val itemsList = List(size = 10){"Item ${it +1}"}

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(itemsList) { index, item ->
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .padding(20.dp)
                    .shadow(
                        elevation = 20.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(randomColor()),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "${index + 1}.$item",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun AdaptiveGrid() {
    val itemsList = List(10){"Items ${it + 1}"}

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 100.dp),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(items = itemsList){ item ->
            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .shadow(
                        elevation = 24.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(randomColor()),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = item,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun StyledGrid() {
    val itemsList = List(50){"Item ${it + 1}"}

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(items = itemsList){item ->
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .shadow(
                        elevation = 24.dp,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(color = Color.LightGray),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = item,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}