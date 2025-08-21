package com.example.composebasicslab.components

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

enum class Page{
    HOME, INFO, SETTINGS
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicScaffold() {
    var selectedPage by remember { mutableStateOf(Page.HOME) }
    var counter by remember { mutableStateOf(0) }
    val context = LocalContext.current
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Scaffold tanulás")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(
                            context,
                            "Vissza gomb megnyomva",
                            Toast.LENGTH_SHORT
                            ).show()
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Vissza gomb")
                    }
                }
            )
        },
        floatingActionButton = {
            if (selectedPage == Page.HOME)
            FloatingActionButton(
                onClick = { counter += 1}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Szamolo gomb"
                    )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when(selectedPage){
                    Page.HOME -> {
                        Text(text = "Szia, Scaffold!")
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Gombnyomások száma: $counter")
                    }
                    Page.INFO -> {
                        Text(text = "Ez egy információs oldal")
                    }
                    Page.SETTINGS -> {
                        Text(text = "Beállítások oldal")

                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar {

                IconButton(onClick = {
                    selectedPage = Page.HOME
                }) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Homepage",
                        tint =
                            if (selectedPage == Page.HOME)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(onClick = { selectedPage = Page.INFO}) {
                    Icon(
                        Icons.Default.Info,
                        contentDescription = "Info page",
                        tint =  if (selectedPage == Page.INFO)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                IconButton(onClick = { selectedPage = Page.SETTINGS}) {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = "Settings page",
                        tint =  if (selectedPage == Page.SETTINGS)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

        }
    )
}