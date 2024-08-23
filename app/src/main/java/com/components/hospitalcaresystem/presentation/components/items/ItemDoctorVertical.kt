package com.components.hospitalcaresystem.presentation.components.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.SpacerHeight
import com.components.hospitalcaresystem.extensions.SpacerWidth
import com.components.hospitalcaresystem.extensions.sdp
import com.components.hospitalcaresystem.presentation.components.HospitalCommonContainer
import com.components.hospitalcaresystem.presentation.components.ResourceImage
import com.components.hospitalcaresystem.presentation.theme.md_theme_light_background

@Composable
fun <T> ItemDoctorVertical(
    modifier: Modifier = Modifier,
    modifierContent : Modifier = Modifier
        .size(55.dp)
        .padding(7.dp),
    image: T,
    title: String,
    containerColor : Color = MaterialTheme.colorScheme.primaryContainer,
    borderColor : Color = MaterialTheme.colorScheme.outline,
    shape: Shape = MaterialTheme.shapes.extraSmall,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .wrapContentWidth()
    ) {
        HospitalCommonContainer(
            modifier = modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
            containerColor = md_theme_light_background,
            borderColor = MaterialTheme.colorScheme.primary
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.sdp, horizontal = 10.sdp)) {
                SpacerHeight(height = 10.sdp)
                ResourceImage(
                    modifier = Modifier
                        .size(100.sdp)
                        .padding(5.sdp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    image = image
                )
                SpacerWidth(width = 10.sdp)
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.sdp)) {
                    Text(text = title, style = MaterialTheme.typography.labelLarge)
                    SpacerHeight(height = 5.sdp)
                    Text(text = "HOD Cardiology, Classified International, Cardiology and Medical Specialist", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
                }
            }
        }
    }
}


@Preview
@Composable
private fun PreviewItemDoctor() {
    ItemDoctorVertical(
        image = R.drawable.img_doc1,
        title = "Dr.Sonia Khan"
    )
}