package com.components.hospitalcaresystem.navigation.screens

import kotlinx.serialization.Serializable

/**
 * A sealed class representing the different screens/routes in the app.
 *
 * @property route The route associated with the screen.
 */
sealed class HospitalCareScreens(val route: String) {

    data object Splash : HospitalCareScreens(route = "splash")

    data object Login : HospitalCareScreens(route = "login")

    data object ResetPin : HospitalCareScreens(route = "reset_pin")

    data object DashboardFlow : HospitalCareScreens(route = "dashboard_flow")

    data object HamburgerMenu : HospitalCareScreens(route = "hamburger_menu")

    data object Error : HospitalCareScreens(route = "error")
}