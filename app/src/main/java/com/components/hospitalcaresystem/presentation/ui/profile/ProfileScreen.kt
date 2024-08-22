package com.components.hospitalcaresystem.presentation.ui.profile

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.components.hospitalcaresystem.presentation.components.ScreenContainer
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.StatusBarColor

@Composable
internal fun ProfileScreenRoute(
    onProfileItemClick: (String) -> Unit
) {
    StatusBarColor(MaterialTheme.colorScheme.onPrimary)
    ProfileScreen(
        onProfileItemClick = onProfileItemClick
    )
}

@Composable
fun ProfileScreen(
    onProfileItemClick: (String) -> Unit = {},
) {
    ScreenContainer {

    }
}


@Composable
@Preview
fun DashboardPreview() {
    HospitalCareAppTheme {
        Surface {
            ProfileScreen()
        }
    }
}