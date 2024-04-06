package com.example.bank.presentation.main

import com.example.bank.domain.repo.Details

data class MainScreenState(
    val details: Details = Details("", "", "", "", "", "",  "", "", "", "", "", "", "", "")
)
