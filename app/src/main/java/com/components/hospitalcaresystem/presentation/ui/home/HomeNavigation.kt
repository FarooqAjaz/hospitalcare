package com.components.hospitalcaresystem.presentation.ui.home

import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.navigation.BottomTabs
import com.components.hospitalcaresystem.presentation.common.AppBarState
import com.components.hospitalcaresystem.presentation.components.SetTopAppBar
import com.components.hospitalcaresystem.presentation.components.ShowDashboardHeader
import com.components.hospitalcaresystem.presentation.ui.doctors.DoctorsScreenRoute
import com.components.hospitalcaresystem.presentation.ui.notification.NotificationScreenRoute
import com.components.hospitalcaresystem.presentation.ui.profile.ProfileScreenRoute


fun NavGraphBuilder.dashboardScreen(onDashboardItemClick: (String) -> Unit, appBarState: AppBarState) {
    composable(route = BottomTabs.Dashboard.route)
    {
        appBarState.ShowDashboardHeader()
        DashboardRoute(onDashboardItemClick=onDashboardItemClick)
    }
}

fun NavGraphBuilder.doctorsScreen(onMenuItemClick: (String) -> Unit, appBarState: AppBarState) {
    composable(route = BottomTabs.Doctors.route)
    {
        appBarState.SetTopAppBar(stringResource(id = R.string.doctors))
        DoctorsScreenRoute(onDoctorItemClick = onMenuItemClick)
    }
}

fun NavGraphBuilder.notificationScreen(onMenuItemClick: (String) -> Unit, appBarState: AppBarState) {
    composable(route = BottomTabs.Notifications.route)
    {
        appBarState.SetTopAppBar(stringResource(id = R.string.notificatoin))
        NotificationScreenRoute(onNotificationItemClick = onMenuItemClick)
    }
}

fun NavGraphBuilder.profileScreen(onMenuItemClick: (String) -> Unit, appBarState: AppBarState) {
    composable(route = BottomTabs.Profile.route)
    {
        appBarState.SetTopAppBar(stringResource(id = R.string.profile))
        ProfileScreenRoute(onProfileItemClick = onMenuItemClick)
    }
}


fun NavController.navigateToBottomTabs(route: String, builder: NavOptionsBuilder.() -> Unit) =
    navigate(route, builder)




