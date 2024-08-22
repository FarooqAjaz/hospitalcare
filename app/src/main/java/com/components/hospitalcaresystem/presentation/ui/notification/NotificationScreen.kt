package com.components.hospitalcaresystem.presentation.ui.notification

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.components.hospitalcaresystem.presentation.components.ScreenContainer
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.StatusBarColor

@Composable
internal fun NotificationScreenRoute(
    onNotificationItemClick: (String) -> Unit
) {
    StatusBarColor(MaterialTheme.colorScheme.onPrimary)
    NotificationScreen(
        onNotificationItemClick = onNotificationItemClick
    )
}

@Composable
fun NotificationScreen(
    onNotificationItemClick: (String) -> Unit = {},
) {
    ScreenContainer {

    }
}


@Composable
@Preview
fun DashboardPreview() {
    HospitalCareAppTheme {
        Surface {
            NotificationScreen()
        }
    }
}