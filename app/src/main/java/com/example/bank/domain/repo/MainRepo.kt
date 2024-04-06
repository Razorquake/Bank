package com.example.bank.domain.repo

import kotlinx.coroutines.flow.Flow

interface MainRepo {
    fun startScanning(): Flow<Details>
}