package com.components.hospitalcaresystem.presentation.bottomtab

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.navigation.BottomTabs
import com.components.hospitalcaresystem.presentation.components.ContainerStyle
import com.components.hospitalcaresystem.presentation.components.ResourceImage
import com.components.hospitalcaresystem.presentation.components.HospitalContainer
import com.components.hospitalcaresystem.presentation.theme.BORDER_GRAY2
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme


@Composable
fun HospitalCareBottomTab(
    modifier: Modifier = Modifier,
    activeTab: BottomTabs? = BottomTabs.Dashboard,
    tabs: List<BottomTabItem> = listOf(),
    onItemClick: (BottomTabs) -> Unit = {}
) {

    HospitalContainer(modifier = modifier.fillMaxWidth(), style = ContainerStyle.Outlined(
        enabledBorderColor = BORDER_GRAY2,
        disabledBorderColor = BORDER_GRAY2,
        enabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ), content = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            tabs.forEach { tab ->
                Box(Modifier.weight(1f)) {
                    BottomTab(
                        tab = tab, isActive = activeTab == tab.type, onClick = onItemClick
                    )
                }
            }
        }
    })
}

@Composable
fun BottomTab(
    tab: BottomTabItem, isActive: Boolean, onClick: (BottomTabs) -> Unit
) {
    val tintColor = if (isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant

    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick(tab.type) }
        .padding(vertical = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        if (tab.type == BottomTabs.Notifications) {
            Spacer(modifier = Modifier.height(10.dp))
            ResourceImage(image = R.drawable.ic_android)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Scan QR", style = MaterialTheme.typography.labelSmall, color = tintColor)
        } else {
            Spacer(modifier = Modifier.height(10.dp))
            ResourceImage(
                image = tab.iconRes,
                modifier = Modifier.size(20.dp),
                colorFilter = ColorFilter.tint(tintColor)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = tab.label), style = MaterialTheme.typography.labelSmall, color = tintColor
            )
        }
    }

}

data class BottomTabItem(
    val type: BottomTabs, val label: Int, val iconRes: Int
)


@Preview
@Composable
private fun PreviewHospitalBottomTab() {
    HospitalCareAppTheme(
        language = "ur"
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.weight(1f))
                HospitalCareBottomTab(
                    tabs = listOf(
                        BottomTabItem(BottomTabs.Dashboard, R.string.home, R.drawable.ic_android),
                        BottomTabItem(BottomTabs.Doctors, R.string.home, R.drawable.ic_android),
                        BottomTabItem(BottomTabs.Notifications, R.string.home, R.drawable.ic_android),
                        BottomTabItem(BottomTabs.Profile, R.string.home, R.drawable.ic_android),
                    )
                )
            }
        }
    }
}