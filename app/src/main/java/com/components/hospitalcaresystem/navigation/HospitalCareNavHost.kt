package com.components.hospitalcaresystem.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.components.hospitalcaresystem.navigation.screens.HospitalCareScreens
import com.components.hospitalcaresystem.presentation.HospitalCareAppState
import com.components.hospitalcaresystem.presentation.common.AppBarState
import com.components.hospitalcaresystem.presentation.ui.auth.navigation.loginScreen
import com.components.hospitalcaresystem.presentation.ui.auth.navigation.navigateToDashboard
import com.components.hospitalcaresystem.presentation.ui.auth.navigation.navigateToResetPin
import com.components.hospitalcaresystem.presentation.ui.home.dashboardScreen
import com.components.hospitalcaresystem.presentation.ui.home.doctorsScreen
import com.components.hospitalcaresystem.presentation.ui.home.notificationScreen
import com.components.hospitalcaresystem.presentation.ui.home.profileScreen
import com.components.hospitalcaresystem.presentation.ui.splash.navigateSplashToLogin
import com.components.hospitalcaresystem.presentation.ui.splash.splashScreenNavigation

@Composable
fun HospitalCareNavHost(
    modifier: Modifier = Modifier,
    appState: HospitalCareAppState,
    startDestination: String = HospitalCareScreens.Splash.route,
    showProgress: (Boolean) -> Unit
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        splashScreenNavigation(onSplashCompleted = {
            navController.navigateSplashToLogin()
        },appBarState=appState.appBarState)

        //Login & Signup
        loginScreen(
            onLoginSuccess = navController::navigateToDashboard,
            showProgress = showProgress,
            onForgetPinClick = { number->
                navController.navigateToResetPin()
            },
            onSignUpClick={
                //navController.navigateToScreen(SignUpRouters.SignUpFlow.route)
            },
            appBarState = appState.appBarState
        )

        homeGraph(navController,appState.appBarState)
    }
}

fun NavGraphBuilder.homeGraph(navController: NavController, appBarState: AppBarState) {
    navigation(
        startDestination = BottomTabs.Dashboard.route, route = HospitalCareScreens.DashboardFlow.route) {
        dashboardScreen(onDashboardItemClick = { navController.navigateToScreen(it)}, appBarState=appBarState)
        doctorsScreen(appBarState = appBarState, onMenuItemClick = {})
        notificationScreen(appBarState = appBarState, onMenuItemClick = {})
        profileScreen(appBarState = appBarState, onMenuItemClick = {})
    }
}

fun NavController.navigateToScreen(route:String, navOptions: NavOptions? = null) =
    navigate(route, navOptions)
