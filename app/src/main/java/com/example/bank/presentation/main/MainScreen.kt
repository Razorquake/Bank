package com.example.bank.presentation.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bank.di.Route

@Composable
fun MainScreen(viewModel: MainViewModel, navController: NavController) {
    val navigateToDetails by viewModel.navigateToDetails.collectAsState()

    if (navigateToDetails) {
        Log.d("MainScreen", "navigateToDetails is true, navigating to DetailScreen")
        navController.navigate(Route.DetailScreen.route)
        // Reset the event
        viewModel.navigateToDetails.tryEmit(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = viewModel::startScanning) {
            Text(text = "Scan")
        }
    }

}