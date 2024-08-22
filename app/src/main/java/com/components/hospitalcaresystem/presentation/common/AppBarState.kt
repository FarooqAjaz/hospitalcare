package com.components.hospitalcaresystem.presentation.common

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface IAppBarState {
    val title: StateFlow<String>
    val isShowTopAppBar: StateFlow<Boolean>
    val isShowDashboardHeader: StateFlow<Boolean>

    fun updateTitle(newTitle: String)
    fun showTopAppBar(isVisible: Boolean)
    fun showDashboardHeader(isVisible: Boolean)
}

class AppBarState : IAppBarState {
    private val _title = MutableStateFlow("Hospital Care")
    override val title: StateFlow<String> = _title

    private val _isShowTopAppBar = MutableStateFlow(false)
    override val isShowTopAppBar: StateFlow<Boolean> = _isShowTopAppBar

    private val _isShowDashboardHeader = MutableStateFlow(false)
    override val isShowDashboardHeader: StateFlow<Boolean> = _isShowDashboardHeader

    override fun updateTitle(newTitle: String) {
        if (_title.value != newTitle) {
            _title.value = newTitle
        }
    }

    override fun showTopAppBar(isVisible: Boolean) {
        if (_isShowTopAppBar.value != isVisible) {
            _isShowTopAppBar.value = isVisible
        }
    }

    override fun showDashboardHeader(isVisible: Boolean) {
        if (_isShowDashboardHeader.value != isVisible) {
            _isShowDashboardHeader.value = isVisible
        }
    }
}

