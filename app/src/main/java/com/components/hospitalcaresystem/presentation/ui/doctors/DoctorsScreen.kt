package com.components.hospitalcaresystem.presentation.ui.doctors

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.components.hospitalcaresystem.presentation.components.ScreenContainer
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.StatusBarColor

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
    ScreenContainer {

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