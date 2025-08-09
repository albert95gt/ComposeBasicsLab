package com.example.composebasicslab.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.composebasicslab.util.getRandomImage
import com.example.composebasicslab.util.getRandomPredefinedColor
import com.example.composebasicslab.util.randomColor

val randomDescriptions = listOf(
    "A beautiful moment captured forever.",
    "Sunny days and happy vibes.",
    "Exploring the unknown.",
    "Just another day in paradise.",
    "Unforgettable memories.",
    "A peaceful afternoon walk.",
    "Adventures are the best way to learn.",
    "Smiles that light up the world.",
    "Wandering without a map.",
    "Simple joys of life.",
    "Dream big, travel far.",
    "Nature always wears the colors of the spirit.",
    "Finding beauty in the ordinary.",
    "One step at a time.",
    "Moments that matter most.",
    "Caught in the act of joy.",
    "Every picture tells a story.",
    "Colors of happiness.",
    "Feeling the breeze and freedom.",
    "This one is special."
)

@Composable
fun SimpleTextCard(){
    Card (
        modifier = Modifier
            .size(300.dp)
            .padding(40.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5),
        )
    ){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "This is a Card component",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun IconTextCard() {
    Card(
        modifier = Modifier
            .size(100.dp),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(40.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Yellow.copy(alpha = 0.3f)),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "star icon"
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Favorite")
            }
        }
    }
}

@Composable
fun InteractiveCardWithButton(){
    var buttonStateMsg by remember { mutableStateOf(false) }
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(40.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = if (buttonStateMsg) "Clicked" else "Not-clicked")
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                buttonStateMsg = !buttonStateMsg
            }) {
                Text(text = "Button")
            }
        }
    }
}

@Composable
fun SimpleCardList(){
    val items = listOf("Item 1", "Item 2", "Item 3","Item 4","Item 5")
    LazyColumn (
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        items(items = items){ item ->
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(12.dp)
            ){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = item)
                }
            }
        }
    }
}

@Composable
fun NumberedCardList(){
    val items = List(10) {"This is the ${it + 1} item"}

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        itemsIndexed(items = items){ index, item ->
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(20.dp)
            ){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text("${index + 1}. $item")
                }
            }
        }
    }
}

@Composable
fun ColoredCardList(){
    val listItems = List(5) {"Item ${it + 1}"}

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ){
        items(items = listItems) { item ->
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(24.dp),
                colors = CardDefaults.cardColors(randomColor())
            ){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = item,
                        color = Color.White
                        )
                }
            }
        }
    }
}

@Composable
fun VerticalImageCard() {
    val imageUrl = "https://picsum.photos/249"
    Card (
        modifier = Modifier.size(230.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(24.dp)
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .build(),
            contentDescription = "Random image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Random image from picsum",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun HorizontalImageCard() {
    val imageUrl = "https://picsum.photos/530"

    Card (
        modifier = Modifier.size(300.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(24.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .build(),
                modifier = Modifier.size(100.dp),
                contentDescription = "Random image",
                contentScale = ContentScale.Crop
            )

            Column (
                modifier = Modifier.padding(12.dp)
            ){
                Text(
                    text = "Some image from picsum",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Easy to use, stylish placeholders.Just add your desired image size (width & height) after our URL, and you'll get a random image.")
            }
        }

    }
}

@Composable
fun ImageCardList() {
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(40.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        itemsIndexed(items = randomDescriptions){ index, description ->
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(20.dp)
            ){
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ){
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(getRandomImage())
                            .build(),
                        contentDescription = "$description",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                    )

                    Text(
                        text = description,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(6.dp)
                    )
                }

            }

        }
    }
}