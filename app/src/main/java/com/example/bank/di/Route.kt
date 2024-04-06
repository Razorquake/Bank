package com.example.bank.di

sealed class Route(
    val route: String
) {
    object MainScreen: Route("mainScreen")
    object DetailScreen: Route("detailScreen")
}