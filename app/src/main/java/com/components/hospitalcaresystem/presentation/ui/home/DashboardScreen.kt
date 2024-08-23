package com.components.hospitalcaresystem.presentation.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.SpacerHeight
import com.components.hospitalcaresystem.extensions.hpr
import com.components.hospitalcaresystem.extensions.sdp
import com.components.hospitalcaresystem.presentation.components.HospitalCareList
import com.components.hospitalcaresystem.presentation.components.HospitalCareSearchField
import com.components.hospitalcaresystem.presentation.components.HospitalSlider
import com.components.hospitalcaresystem.presentation.components.LayoutType
import com.components.hospitalcaresystem.presentation.components.ResourceImage
import com.components.hospitalcaresystem.presentation.components.ScreenContainer
import com.components.hospitalcaresystem.presentation.components.SliderIndicator
import com.components.hospitalcaresystem.presentation.components.items.ItemDashboard
import com.components.hospitalcaresystem.presentation.components.items.ItemDoctor
import com.components.hospitalcaresystem.presentation.components.items.ItemDoctorVertical
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.StatusBarColor
import com.wallet.zindigi.hamburgermenu.datahandler.HospitalCareDataHandler

@Composable
internal fun DashboardRoute(
    onDashboardItemClick: (String) -> Unit
) {
    StatusBarColor(MaterialTheme.colorScheme.onPrimary)
    DashboardScreen(
        onDashboardItemClick = onDashboardItemClick
    )
}

@Composable
fun DashboardScreen(
    onDashboardItemClick: (String) -> Unit = {},
) {
    val dashboardList = HospitalCareDataHandler.getDashboarDatea()
    val doctorList = HospitalCareDataHandler.getDoctorsList()
    ScreenContainer {
        Column(Modifier.fillMaxWidth()) {
            SpacerHeight(height = 10.sdp)
            HospitalCareSearchField(onSearch = {})
            SpacerHeight(height = 10.sdp)
            HospitalCareList(
                items = dashboardList,
                layoutType = LayoutType.GRID,
                gridSpanCount = 2,
                horizontalArrangement = Arrangement.spacedBy(5.sdp),
                verticalArrangement = Arrangement.spacedBy(10.sdp),
                itemContent = { item, pos ->
                    ItemDashboard(image = item.image, title = item.title)
                })

            SpacerHeight(height = 15.sdp)
            Text(text = "Book a Doctor", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.primary)
            SpacerHeight(height = 10.sdp)
            HospitalCareList(
                items = doctorList,
                itemContent = { item, pos ->
                    SpacerHeight(height = 10.sdp)
                    ItemDoctorVertical(image = item.image, title = item.title)
                })
        }
    }
}



@Composable
@Preview
fun DashboardPreview() {
    HospitalCareAppTheme {
        Surface {
            DashboardScreen()
        }
    }
}