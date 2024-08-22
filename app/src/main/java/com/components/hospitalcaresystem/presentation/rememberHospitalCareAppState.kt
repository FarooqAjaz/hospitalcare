package com.components.hospitalcaresystem.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.components.hospitalcaresystem.presentation.common.AppBarState
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberHospitalCareAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): HospitalCareAppState {
    return remember(
        navController,
        coroutineScope
    ) {
        HospitalCareAppState(
            navController = navController
        )
    }
}

@Stable
class HospitalCareAppState(
    val navController: NavHostController,
) {
    val appBarState = AppBarState()
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    fun navigateBack(){
        navController.popBackStack()
    }
}

