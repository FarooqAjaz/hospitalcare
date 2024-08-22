package com.components.hospitalcaresystem.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import com.components.hospitalcaresystem.presentation.theme.Dimensions
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.LocalDimensions
import com.components.hospitalcaresystem.presentation.theme.LocalThemeMode
import com.components.hospitalcaresystem.presentation.theme.ThemeMode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val isDarkTheme = false
            val appState = rememberHospitalCareAppState()
            val localDimensions = Dimensions()
            val localThemeMode = ThemeMode(isDarkTheme)

            CompositionLocalProvider(
                androidx.lifecycle.compose.LocalLifecycleOwner provides androidx.compose.ui.platform.LocalLifecycleOwner.current,
                LocalDimensions provides localDimensions,
                LocalThemeMode provides localThemeMode
            ) {
                HospitalCareAppTheme(
                    darkTheme = isDarkTheme
                ) {
                    HospitalCareApp(appState)
                }
            }
        }
    }
}
