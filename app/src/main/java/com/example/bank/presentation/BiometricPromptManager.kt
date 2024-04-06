package com.example.bank.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import java.util.concurrent.Executor

class BiometricPromptManager(
    private val activity: AppCompatActivity
) {
    fun showBiometricPrompt(
        title: String,
        description: String,
        executor: Executor,
        callback: BiometricPrompt.AuthenticationCallback
    ) {
        // Show biometric prompt
        val manager = BiometricManager.from(activity)
        val authenticators = BIOMETRIC_STRONG or DEVICE_CREDENTIAL
        val promptInfo = androidx.biometric.BiometricPrompt.PromptInfo.Builder()
            .setTitle(title)
            .setDescription(description)
            .setAllowedAuthenticators(authenticators)
            .build()
        val biometricPrompt = BiometricPrompt(activity, executor, callback)
        biometricPrompt.authenticate(promptInfo)
    }
}