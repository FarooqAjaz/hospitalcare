package com.components.hospitalcaresystem.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.presentation.common.IAppBarState

@Composable
fun IAppBarState.SetTopAppBar(title: String){
    LaunchedEffect(Unit) {
        this@SetTopAppBar.updateTitle(title)
        this@SetTopAppBar.showTopAppBar(true)
        this@SetTopAppBar.showDashboardHeader(false)
    }
}
@Composable
fun IAppBarState.ShowDashboardHeader(){
    val title:String= stringResource(id = R.string.hospital_care)
    LaunchedEffect(Unit) {
        this@ShowDashboardHeader.updateTitle(title)
        this@ShowDashboardHeader.showTopAppBar(true)
        this@ShowDashboardHeader.showDashboardHeader(true)
    }
}
@Composable
fun IAppBarState.HideTopAppBar(){
    val title:String= stringResource(id = R.string.hospital_care)
    LaunchedEffect(Unit) {
        this@HideTopAppBar.updateTitle(title)
        this@HideTopAppBar.showTopAppBar(false)
        this@HideTopAppBar.showDashboardHeader(false)
    }
}
