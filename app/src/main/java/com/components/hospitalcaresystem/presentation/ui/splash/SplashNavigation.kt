package com.components.hospitalcaresystem.presentation.ui.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.components.hospitalcaresystem.navigation.screens.HospitalCareScreens
import com.components.hospitalcaresystem.presentation.common.AppBarState

fun NavGraphBuilder.splashScreenNavigation(
    onSplashCompleted: () -> Unit,
    appBarState: AppBarState
) {
    composable(route = HospitalCareScreens.Splash.route)
    {
        SplashRoute(
            onSplashCompleted = onSplashCompleted,
            appBarState = appBarState
        )
    }
}

fun NavController.navigateSplashToLogin() {
    navigate(route = HospitalCareScreens.Login.route) {
        popUpTo(route = HospitalCareScreens.Splash.route) { inclusive = true }
    }
}