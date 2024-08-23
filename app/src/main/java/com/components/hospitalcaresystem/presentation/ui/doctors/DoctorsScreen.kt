package com.components.hospitalcaresystem.presentation.ui.doctors

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.components.hospitalcaresystem.extensions.SpacerHeight
import com.components.hospitalcaresystem.extensions.sdp
import com.components.hospitalcaresystem.presentation.components.HospitalCareList
import com.components.hospitalcaresystem.presentation.components.HospitalCareSearchField
import com.components.hospitalcaresystem.presentation.components.LayoutType
import com.components.hospitalcaresystem.presentation.components.ScreenContainer
import com.components.hospitalcaresystem.presentation.components.items.ItemDoctor
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.StatusBarColor
import com.wallet.zindigi.hamburgermenu.datahandler.HospitalCareDataHandler

@Composable
internal fun DoctorsScreenRoute(
    onDoctorItemClick: (String) -> Unit
) {
    StatusBarColor(MaterialTheme.colorScheme.onPrimary)
    DoctorsScreen(
        onDashboardItemClick = onDoctorItemClick
    )
}

@Composable
fun DoctorsScreen(
    onDashboardItemClick: (String) -> Unit = {},
) {
    val doctorList = HospitalCareDataHandler.getDoctorsList()
    ScreenContainer {
        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())) {
            SpacerHeight(height = 10.sdp)
            HospitalCareSearchField(onSearch = {})
            SpacerHeight(height = 10.sdp)
            HospitalCareList(
                items = doctorList,
                layoutType = LayoutType.GRID,
                gridSpanCount = 2,
                horizontalArrangement = Arrangement.spacedBy(5.sdp),
                verticalArrangement = Arrangement.spacedBy(10.sdp),
                itemContent = { item, pos ->
                    ItemDoctor(image = item.image, title = item.title, description = item.description )
                })

        }
    }
}


@Composable
@Preview
fun DashboardPreview() {
    HospitalCareAppTheme {
        Surface {
            DoctorsScreen()
        }
    }
}