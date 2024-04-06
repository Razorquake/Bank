package com.example.bank.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bank.di.Route
import com.example.bank.presentation.details.DetailsScreen
import com.example.bank.presentation.main.MainScreen
import com.example.bank.presentation.main.MainViewModel

@Composable
fun NavGraph(){
    val viewModel: MainViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val navController = rememberNavController()
    NavHost(
        startDestination = Route.MainScreen.route,
        navController = navController
    ){

        composable(Route.MainScreen.route){
            MainScreen(viewModel, navController = navController)
        }
        composable(Route.DetailScreen.route) {
            DetailsScreen(state.details)
        }
    }
}