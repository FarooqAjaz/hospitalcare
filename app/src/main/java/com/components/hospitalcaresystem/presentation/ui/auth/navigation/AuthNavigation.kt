package com.components.hospitalcaresystem.presentation.ui.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.components.hospitalcaresystem.navigation.screens.HospitalCareScreens
import com.components.hospitalcaresystem.presentation.common.AppBarState
import com.components.hospitalcaresystem.presentation.ui.auth.LoginRoute
import com.components.hospitalcaresystem.presentation.ui.auth.ResetPasswordScreenRoute

const val SPLASH_ROUTE = "splash"
const val LOGIN_ROUTE = "login"
const val SIGN_UP_ROUTE = "signup"
const val RESET_PIN_ROUTE = "reset_pin"

fun NavGraphBuilder.loginScreen(
    onLoginSuccess: () -> Unit,
    showProgress: (Boolean) -> Unit,
    onForgetPinClick: (String) -> Unit,
    onSignUpClick: () -> Unit,
    appBarState: AppBarState,
) {
    composable(route = HospitalCareScreens.Login.route)
    {
        LoginRoute(
            onLoginSuccess = onLoginSuccess,
            showProgress = showProgress,
            onForgetPinClick = onForgetPinClick,
            onSignUpClick=onSignUpClick,
            appBarState=appBarState,
        )
    }

    composable(route = HospitalCareScreens.ResetPin.route)
    {
        ResetPasswordScreenRoute(onItemClick = {})
    }
}


fun NavController.navigateToLogin(navOptions: NavOptions? = null) =
    navigate(HospitalCareScreens.Login.route, navOptions)

fun NavController.navigateToDashboard(navOptions: NavOptions? = null) =
    navigate(HospitalCareScreens.DashboardFlow.route, navOptions)

fun NavController.navigateToSignup(navOptions: NavOptions? = null) =
    navigate(SIGN_UP_ROUTE, navOptions)


fun NavController.navigateToResetPin(navOptions: NavOptions? = null) =
    navigate(HospitalCareScreens.ResetPin.route, navOptions)
