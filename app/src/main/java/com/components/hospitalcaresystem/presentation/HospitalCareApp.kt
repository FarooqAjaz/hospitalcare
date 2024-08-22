package com.components.hospitalcaresystem.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.navigation.BottomTabs
import com.components.hospitalcaresystem.navigation.HospitalCareNavHost
import com.components.hospitalcaresystem.presentation.bottomtab.BottomTabItem
import com.components.hospitalcaresystem.presentation.bottomtab.HospitalCareBottomTab
import com.components.hospitalcaresystem.presentation.components.HospitalCareBackground
import com.components.hospitalcaresystem.presentation.header.AppBarHeader
import com.components.hospitalcaresystem.presentation.ui.home.navigateToBottomTabs

/**
 * Root HospitalCareApp App Composable
 */
@Composable
fun HospitalCareApp(appState: HospitalCareAppState, modifier: Modifier = Modifier) {
    HospitalCareBackground(
        modifier = modifier,
    ) {
        HospitalCareInternal(modifier, appState)
    }
}

@Composable
internal fun HospitalCareInternal(
    modifier: Modifier = Modifier, appState: HospitalCareAppState
) {
    var showProgressDialog by rememberSaveable { mutableStateOf(false) }
    var activeTab: BottomTabs? by remember { mutableStateOf(BottomTabs.Dashboard) }
    // Show the top app bar on top level destinations.
    val title by appState.appBarState.title.collectAsState()
    val isShowTopAppBar by appState.appBarState.isShowTopAppBar.collectAsState()
    val isShowDashboardHeader by appState.appBarState.isShowDashboardHeader.collectAsState()

    Scaffold(
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            Column(
                Modifier.fillMaxSize(),
            ) {
                if (isShowTopAppBar) {
                    AppBarHeader(title = title,
                        showDashboardHeader = isShowDashboardHeader,
                        //onDrawerClick = {appState.navController.navigateToHamburger()},
                        onDrawerClick = {},
                        onSmsClick = {},
                        smsCount = "10",
                        onNotificationClick = {},
                        notificationCount = "10",
                        onBackClick = {
                            appState.navigateBack()
                        })
                }
                HospitalCareNavHost(modifier = Modifier.weight(1f),
                    appState = appState,
                    showProgress = {
                        showProgressDialog = it
                    })
                if (isShowDashboardHeader) {
                    HospitalCareBottomTab(tabs = getListOfTabs(),
                        activeTab = activeTab,
                        onItemClick = { tab ->
                            if (activeTab != null && activeTab != tab) {
                                activeTab = tab
                                when (tab) {
                                    BottomTabs.Dashboard -> appState.navController.navigateToBottomTabs(
                                        BottomTabs.Dashboard.route
                                    ) {
                                        appState.navController.graph.startDestinationRoute?.let { screen_route ->
                                            popUpTo(route = screen_route)
                                        }
                                    }

                                    BottomTabs.Doctors -> appState.navController.navigateToBottomTabs(
                                        BottomTabs.Doctors.route
                                    ) {
                                        appState.navController.graph.startDestinationRoute?.let { screen_route ->
                                            popUpTo(route = screen_route)
                                        }
                                    }

                                    BottomTabs.Notifications -> appState.navController.navigateToBottomTabs(
                                        BottomTabs.Notifications.route
                                    ) {
                                        appState.navController.graph.startDestinationRoute?.let { screen_route ->
                                            popUpTo(route = screen_route)
                                        }
                                    }

                                    BottomTabs.Profile -> appState.navController.navigateToBottomTabs(
                                        BottomTabs.Profile.route
                                    ) {
                                        appState.navController.graph.startDestinationRoute?.let { screen_route ->
                                            popUpTo(route = screen_route)
                                        }
                                    }
                                }
                            }
                        })
                }
            }
        }
    }
}

fun getListOfTabs() = listOf(
    BottomTabItem(BottomTabs.Dashboard, R.string.home, R.drawable.ic_tab_home),
    BottomTabItem(BottomTabs.Doctors, R.string.doctors, R.drawable.ic_doctor),
    BottomTabItem(BottomTabs.Notifications, R.string.news, R.drawable.ic_news),
    BottomTabItem(BottomTabs.Profile, R.string.profile, R.drawable.ic_profile)
)
