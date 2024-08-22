package com.components.hospitalcaresystem.presentation.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.presentation.common.AppBarState
import com.components.hospitalcaresystem.presentation.components.ResourceIcon
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.StatusBarColor
import kotlinx.coroutines.delay

@Composable
internal fun SplashRoute(
    onSplashCompleted: () -> Unit,
    appBarState: AppBarState
) {
    SplashScreen(onSplashCompleted = onSplashCompleted)
}

@Composable
fun SplashScreen(onSplashCompleted: () -> Unit) {
    StatusBarColor(MaterialTheme.colorScheme.primary)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            ResourceIcon(icon = R.drawable.img_splash, tint = MaterialTheme.colorScheme.primary)
            Text(text = "Welcome to Hospital Care App", style = MaterialTheme.typography.labelLarge)
        }

        LaunchedEffect(key1 = true) {
            delay(2000)
            onSplashCompleted()
        }
    }
}

@Preview
@Composable
fun PreviewSplash(){
    HospitalCareAppTheme {
        Surface {
            SplashScreen(onSplashCompleted = {})
        }
    }
}
