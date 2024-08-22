package com.components.hospitalcaresystem.presentation.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.hospitalcaresystem.presentation.components.HospitalContainerWithIcon
import com.components.hospitalcaresystem.presentation.components.ResourceIcon

/**
 * A composable function that defines how each item should be displayed.
 * @param title: The title text for the each item (String).
 * @param description: An optional description text for the each item (String).
 * @param leftIcon: An optional ImageVector resource to display left icon (ImageVector).
 * @param rightIcon: An optional ImageVector resource to display right icon (ImageVector).
 */
@Composable
fun <T> SheetItem(
    title: String,
    description: String? = null,
    leftIcon: T? = null,
    rightIcon: T? = null,
    iconWithCardBg:Boolean=false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left icon (optional)
            leftIcon?.let {
                if (iconWithCardBg){
                    HospitalContainerWithIcon(icon = it, modifier = Modifier.size(50.dp).padding(7.dp))
                }else{
                    ResourceIcon(icon = it, modifier =Modifier.size(40.dp))
                }
            }
        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
            // Title (mandatory)
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .fillMaxWidth()
            )
            // Description (optional)
            if (description != null) {
                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
        // Right icon (optional)
        rightIcon?.let {
            if (iconWithCardBg){
                HospitalContainerWithIcon(icon = it, modifier = Modifier.size(50.dp).padding(7.dp))
            }else{
                ResourceIcon(icon = it, modifier =Modifier.size(40.dp))
            }
        }
    }
}

@Preview(name = "SheetItem")
@Composable
private fun PreviewSheetItem() {
    SheetItem(title = "Pakistan", leftIcon =null)
}