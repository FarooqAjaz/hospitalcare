package com.components.hospitalcaresystem.presentation.header

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.sdp
import com.components.hospitalcaresystem.extensions.ssp
import com.components.hospitalcaresystem.presentation.components.HospitalContainerWithIcon
import com.components.hospitalcaresystem.presentation.components.ResourceImage
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme


@Composable
fun AppBarHeader(
    title: String,
    showDashboardHeader: Boolean,
    onDrawerClick: () -> Unit,
    onSmsClick: () -> Unit,
    smsCount: String,
    onNotificationClick: () -> Unit,
    notificationCount: String,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (showDashboardHeader) {
            DashboardHeader(
                onDrawerClick = onDrawerClick,
                onSmsClick = onSmsClick,
                smsCount = smsCount,
                onNotificationClick = onNotificationClick,
                notificationCount = notificationCount
            )
        } else {
            InnerHeader(
                onBackClick = onBackClick, title = title
            )
        }
    }
}

@Composable
fun DashboardHeader(
    onDrawerClick: () -> Unit,
    onSmsClick: () -> Unit,
    smsCount: String,
    onNotificationClick: () -> Unit,
    notificationCount: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.sdp) // we will replace with our header_height
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        HospitalContainerWithIcon(icon = R.drawable.ic_drawer_menu,
            modifier = Modifier.clickable {  onDrawerClick() },
            modifierContent = Modifier
            .size(25.sdp)
            .padding(6.sdp))

        Spacer(modifier = Modifier.width(8.dp))
        Box {
            HospitalContainerWithIcon(icon = R.drawable.ic_sms,
                modifier = Modifier.clickable {  onSmsClick() },
                modifierContent = Modifier
                    .size(25.sdp)
                    .padding(6.sdp))
            if (smsCount.isNotEmpty() && smsCount != "0") {
                Box(
                    modifier = Modifier
                        .size(18.sdp)
                        .align(Alignment.TopEnd)
                        .offset(x = 6.sdp, y = (-10).dp)
                        .padding(2.sdp)
                        .background(Color.Red, shape = RoundedCornerShape(25.sdp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = smsCount,
                        fontSize = 7.ssp,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        ResourceImage(
            image = R.drawable.ic_android,
            modifier = Modifier.padding(end = 3.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Box {
            HospitalContainerWithIcon(icon = R.drawable.ic_zindigi_heading,
                modifier = Modifier.clickable {  onNotificationClick() },
                modifierContent = Modifier
                    .size(25.sdp)
                    .padding(6.sdp))
            if (notificationCount.isNotEmpty() && notificationCount != "0") {
                Box(
                    modifier = Modifier
                        .size(18.sdp)
                        .align(Alignment.TopEnd)
                        .offset(x = 6.sdp, y = (-10).dp)
                        .padding(2.sdp)
                        .background(Color.Red, shape = RoundedCornerShape(25.sdp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = notificationCount,
                        fontSize = 7.ssp,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun InnerHeader(
    onBackClick: () -> Unit, title: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp) // we will replace with our header_height
            .padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        ResourceImage(image = R.drawable.ic_back, modifier = Modifier.clickable { onBackClick() })
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.weight(1f)
        )
    }
}


@Preview(name = "HeaderAppBar")
@Composable
private fun PreviewHeaderAppBar() {
    HospitalCareAppTheme(
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
            ) {
                AppBarHeader(
                    title = "Zindigi",
                    showDashboardHeader = true,
                    onDrawerClick = {},
                    onSmsClick = {},
                    smsCount = "10",
                    onNotificationClick = {},
                    notificationCount = "10",
                    onBackClick = {}
                )
            }
        }
    }
}