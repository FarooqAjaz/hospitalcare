package com.components.hospitalcaresystem.navigation

import com.components.hospitalcaresystem.R
/**
 * Hospital Care app top level destinations. Each of these destinations
 * contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */
enum class HospitalCareTopLevelDestinations(
    val titleTextId: Int = R.string.hospital_care,
    val isShowTitleBar: Boolean = true
) {
    SPLASH(
        isShowTitleBar = false
    ),
    Login(
        titleTextId = R.string.login,
        isShowTitleBar = false
    ),
    Dashboard(
        titleTextId = R.string.dashboard
    )
}