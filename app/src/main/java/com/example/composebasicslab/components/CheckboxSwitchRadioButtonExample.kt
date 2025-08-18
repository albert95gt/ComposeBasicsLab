package com.example.composebasicslab.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskCheckbox() {
    var isCheckedState by remember { mutableStateOf(false) }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(
            checked = isCheckedState,
            onCheckedChange = {newState -> isCheckedState = newState }
        )

        Text(
            text = if (isCheckedState) "Feladat kész ✅" else "Feladat nincs kész"
        )
    }
}

@Composable
fun DarkModeSwitch() {
    var isDarkTheme by remember { mutableStateOf(false) }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Switch(
            checked = isDarkTheme,
            onCheckedChange = {isDarkTheme = it}
        )

        Text(
            text = if (!isDarkTheme) "Világos mód" else "Sötét mód",
            modifier = Modifier.padding(horizontal = 6.dp)
        )
    }
}

@Composable
fun PizzaSizeSelector() {
    val options = listOf("Kicsi", "Közepes", "Nagy")
    var selectedOptions by remember { mutableStateOf(options[0]) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        options.forEach { option ->
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = (selectedOptions == option) ,
                    onClick = {selectedOptions = option }
                )

                Text(
                    text = option,
                    modifier = Modifier.padding(horizontal = 6.dp)
                    )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Kiválasztott méret: $selectedOptions")
    }
}