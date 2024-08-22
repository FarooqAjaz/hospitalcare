package com.components.hospitalcaresystem.navigation



sealed class BottomTabs(var route:String){
    data object Dashboard:BottomTabs("dashboard")
    data object Doctors:BottomTabs("doctors")
    data object Notifications:BottomTabs("notification")
    data object Profile:BottomTabs("profile")
}