package com.example.composebasicslab.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun DeleteConfirmationDialog() {
    var showDialog by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Button(
            onClick = {
                showDialog = true
            }
        ) {
            Text(text = "Törlés")
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {showDialog = false},
                title = {
                    Text(text = "Biztosan törlöd?")
                        },

                text = {
                    Text(text = "Ez a művelet nem visszavonható.")
                       },

                confirmButton = {
                        Button(onClick = { showDialog = false }) {
                            Text(text = "Igen")
                        }
                },

                dismissButton = {
                    Button(
                        onClick = { showDialog = false }
                    ) {
                        Text(text = "Mégse")
                    }
                }
            )
        }
    }
}

@Composable
fun SimpleSnackbar() {
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ){ paddingValues ->
        Box(

            modifier = Modifier
                .padding(paddingValues)
                .padding(20.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){

            Button(
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Ez egy egyszerű üzenet!"
                        )
                    }
                }
            ) {

                Text(text = "Mutass Snackbar-t")
            }
        }
    }
}

@Composable
fun SnackbarWithAction() {
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ){ paddingValues ->
        Box(

            modifier = Modifier
                .padding(paddingValues)
                .padding(20.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){

            Button(
                onClick = {
                    coroutineScope.launch {
                         val result =   snackbarHostState.showSnackbar(
                                message = "Ez egy egyszerű üzenet!",
                                actionLabel = "Visszavonás"
                            )

                        if (result == SnackbarResult.ActionPerformed){
                            Log.d("Snackbar Action","Visszavonás megnyomva!")
                        }
                    }
                }
            ) {

                Text(text = "Mutass Snackbar-t")
            }
        }
    }
}