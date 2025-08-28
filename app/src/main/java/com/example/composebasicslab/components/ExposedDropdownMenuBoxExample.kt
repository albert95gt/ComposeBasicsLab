package com.example.composebasicslab.components

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleExposedDropdownMenuBox() {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Piros", "Zöld", "Kék")
    var selectedOption by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded}
    ) {
        TextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            label = {
                Text(text = "Válassz színt")
            },
            modifier = Modifier
                .menuAnchor(
                    type = MenuAnchorType.PrimaryNotEditable,
                    enabled = true
                )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false}
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(text = option)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategorizedColorDropdown() {

    val colorCategories = mapOf(
        "Alapszínek" to listOf("Piros", "Zöld", "Kék"),
        "Pastell színek" to listOf("Világos rózsaszín", "Világos kék", "Bézs"),
        "Sötét színek" to listOf("Sötét piros", "Sötét zöld", "Sötét kék")
    )

    var expanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf(colorCategories.keys.first()) }
    var selectedColor by remember { mutableStateOf(colorCategories[selectedCategory]!![0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded}
    ) {
        TextField(
            value = "$selectedCategory - $selectedColor",
            onValueChange = {},
            readOnly = true,
            label = {
                Text(text = "Válassz színt")
            },
            modifier = Modifier
                .menuAnchor(
                    type = MenuAnchorType.PrimaryNotEditable,
                    enabled = true
                )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false}
        ) {
            colorCategories.forEach { (category, colors) ->
                DropdownMenuItem(
                    text = {
                        Text(text = category)
                    },
                    onClick = {},
                    enabled = false
                )

                colors.forEach { color ->
                    DropdownMenuItem(
                        text = {
                            Text(text = color)
                        },
                        onClick = {
                            selectedCategory = category
                            selectedColor = color
                            expanded = false
                        }
                    )
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TwoStepColorDropdown() {
    val colorCategories = mapOf(
        "Alapszínek" to listOf("Piros", "Zöld", "Kék"),
        "Pastell színek" to listOf("Világos rózsaszín", "Világos kék", "Bézs"),
        "Sötét színek" to listOf("Sötét piros", "Sötét zöld", "Sötét kék")
    )

    var expanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf(colorCategories.keys.first()) }
    var selectedColor by remember { mutableStateOf(colorCategories[selectedCategory]!![0]) }
    var activeCategory by remember { mutableStateOf<String?>(null) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded}
    ) {
        TextField(
            value = "$selectedCategory - $selectedColor",
            onValueChange = {},
            readOnly = true,
            label = {
                Text(text = "Válassz színt")
            },
            modifier = Modifier
                .menuAnchor(
                    type = MenuAnchorType.PrimaryNotEditable,
                    enabled = true
                )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
                activeCategory = null
            }
        ) {
            if (activeCategory == null){
                colorCategories.keys.forEach { category ->
                    DropdownMenuItem(
                        text = {
                            Text(text = category)
                        },
                        onClick = {
                            activeCategory = category
                        },
                        enabled = true
                    )
                }
            } else {
                colorCategories[activeCategory]!!.forEach { color ->
                    DropdownMenuItem(
                        text = {
                            Text(text = color)
                        },
                        onClick = {
//                            val category = activeCategory
//                            if (category != null) {
//                                selectedCategory = category
//                            }
                            selectedCategory = activeCategory!!
                            selectedColor = color
                            expanded = false
                            activeCategory = null
                        }
                    )
                }
            }
        }
    }

}