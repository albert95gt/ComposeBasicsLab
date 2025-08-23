package com.example.composebasicslab.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

val choices = listOf("Első", "Második", "Harmadik")

@Composable
fun SimpleNavigationApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){ HomeScreen(navController)}
        composable("details/{userChoice}") { backStackEntry ->
            val choice = backStackEntry.arguments?.getString("userChoice")
            if (choice != null) {
                DetailsScreen(navController, choice)
            }
        }
        composable("settings"){ SettingsScreen(navController)}
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    var userText by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = userText,
            onValueChange = {userText = it},
            label = {Text(text = "Az uzeneted:")}
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                if (userText.isNotBlank()){
                    val encodedText = Uri.encode(userText)
                    navController.navigate("details/$encodedText")
                }
            }
        ) {
            Text(text = "Ugrás a részletekhez")
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        choices.forEach { choice ->
            Button(
                onClick = {
                    val encodedChoice = Uri.encode(choice)
                    navController.navigate("details/$encodedChoice")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(choice)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("settings") }
        ) {
            Text(text = "Ugrás a bealitasokhoz")
        }

    }
}

@Composable
fun DetailsScreen(navController: NavHostController, choice: String) {
    val decodedChoice = Uri.decode(choice)

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Ez a részletek képernyő")

        Text(text = "Felhasználói szöveg / választás: $decodedChoice")

        Button(onClick = {
            navController.popBackStack("home", inclusive = false)
        }) {
            Text(text = "Vissza a kezdo képernyőre")
        }
    }
}

@Composable
fun SettingsScreen(navController: NavHostController) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Ez a bealitasok képernyő")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.popBackStack("home", inclusive = false)
            }
        ) {
            Text(text = "Vissza a kezdo képernyőre")
        }
    }
}

