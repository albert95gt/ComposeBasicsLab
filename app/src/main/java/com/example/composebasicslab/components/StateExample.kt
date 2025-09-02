package com.example.composebasicslab.components

import android.widget.Button
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.temporal.TemporalAmount

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

@Composable
fun TwoWayCounter() {
    var counter by remember { mutableStateOf(0) }
    var textColor = if (counter >= 5) Color.Red else Color.Black

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Counter value: $counter",
            color = textColor
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,

        ){
            Button(
                onClick = { counter += 1}
            ) {
                Text(text = "Count up")
            }
            Spacer(modifier = Modifier.width(5.dp))
            Button(
                onClick = {
                    if (counter > 0)
                    counter -= 1
                }
            ) {
                Text(text = "Count down")
            }
        }
    }
}

@Composable
fun IngredientsCounter() {
    var sugarAmount by remember { mutableStateOf<Double>(0.0) }
    var flourAmount by remember { mutableStateOf(0.0) }
    var totalAmount by remember { mutableStateOf(0.0) }

    var sugarTextColor = if (sugarAmount >= 5) Color.Red else Color.Black
    var flourTextColor = if (flourAmount >= 5) Color.Red else Color.Black
    var totalAmountTextColor = if (totalAmount >= 10) Color.Red else Color.Black

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Sugar amount : ${"%.1f".format(sugarAmount)} g",
                color = sugarTextColor
            )

            Button(
                onClick = {sugarAmount += 0.1}
            ) {
                Text(text = "add")
            }

            Button(
                onClick = {
                    if (sugarAmount > 0)
                    sugarAmount -= 0.1
                }
            ) {
                Text(text = "remove")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Flour amount : ${"%.1f".format(flourAmount)} g",
                color = flourTextColor
            )

            Button(
                onClick = {flourAmount += 0.1}
            ) {
                Text(text = "add")
            }

            Button(
                onClick = {
                    if (flourAmount > 0)
                        flourAmount -= 0.1
                }
            ) {
                Text(text = "remove")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider(modifier = Modifier.fillMaxWidth())
        Text(
            text = "Total cost: $totalAmount Kc",
            color = totalAmountTextColor,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        Button(
            onClick = {
                totalAmount = sugarAmount * 20 + flourAmount * 15
            }
        ) {
            Text(text = "Calculate total count")
        }
    }
}

data class Ingredient(
    val name: String,
    val price: Double,
    var amount: MutableState<Double> = mutableStateOf(0.0),

)

@Composable
fun IngredientsListCounter() {
    val context = LocalContext.current
    val ingredients = remember {
        mutableStateListOf(
            Ingredient("Sugar",  20.0),
            Ingredient("Flour",  15.0),
            Ingredient("Butter",  150.0),
            Ingredient("Egg",  200.0),
            Ingredient("Milk",  50.0),
            Ingredient("Cocoa",  100.0)
        )
    }
    var newIngredientName by remember { mutableStateOf("") }
    var newIngredientPriceText by remember { mutableStateOf("") }

    var nameError by remember { mutableStateOf(false) }
    var priceError by remember { mutableStateOf(false) }

    val totalAmount by remember { derivedStateOf { ingredients.sumOf { it.amount.value } } }
    val totalPrice by remember { derivedStateOf { ingredients.sumOf { it.amount.value * it.price } } }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            TextField(
                value = newIngredientName,
                onValueChange = { input ->
                    newIngredientName = input.replaceFirstChar{
                        if (it.isLowerCase()) it.titlecase() else it.toString()
                    }
                    nameError = false
                },
                label = {
                    Text(text = "New ingredient name")
                },
                isError = nameError
            )
            if (nameError){
                Text(
                    text = "Please enter a valid name",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            TextField(
                value = newIngredientPriceText,
                onValueChange = {
                    newIngredientPriceText = it
                    priceError = false
                },
                label = {
                    Text(text = "Ingredient price")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = priceError
            )
            if (priceError){
                Text(
                    text = "Price must be greater than 0",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Button(
                onClick = {
                    val price = newIngredientPriceText.toDoubleOrNull()
                    val name = newIngredientName.trim()

                    nameError = name.isBlank()
                    priceError = price == null || price <= 0.0

                    if (!nameError && !priceError) {
                        if (ingredients.any { it.name.equals(name, ignoreCase = true) }) {
                            Toast.makeText(
                                context,
                                "This ingredient already exists!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            ingredients.add(Ingredient(name, price!!))
                            newIngredientName = ""
                            newIngredientPriceText = ""

                            Toast.makeText(
                                context,
                                "The new ingredient has been added",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            ) {
                Text(text = "Add new ingredient")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn (
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(ingredients){ingredient ->

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(text = "${ingredient.name}")

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        IconButton(
                            onClick = {
                                ingredient.amount.value += 0.1
                            }
                        ) {
                            Icon(
                                imageVector =  Icons.Default.KeyboardArrowUp,
                                contentDescription = "Add"
                            )
                        }
                        Text(text = "amount: ${"%.1f".format(ingredient.amount.value)} g")
                        IconButton(
                            onClick = {
                                if (ingredient.amount.value > 0)
                                ingredient.amount.value -= 0.1
                            }
                        ) {
                            Icon(
                                imageVector =  Icons.Default.KeyboardArrowDown,
                                contentDescription = "Remove"
                            )
                        }

                    }
                }
            }
        }
        HorizontalDivider(modifier = Modifier.fillMaxWidth())
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Total amount: ${"%.1f".format(totalAmount)} g",
                color = if (totalAmount >= 10) Color.Red else Color.Black
            )
            Text(
                text = "Total price: ${"%.0f".format(totalPrice)} Kc",
                color = if (totalPrice >= 500) Color.Red else Color.Black
            )
        }
    }
}