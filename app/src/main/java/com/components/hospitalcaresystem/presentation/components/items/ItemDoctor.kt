package com.components.hospitalcaresystem.presentation.components.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.SpacerHeight
import com.components.hospitalcaresystem.extensions.sdp
import com.components.hospitalcaresystem.presentation.components.HospitalCommonContainer
import com.components.hospitalcaresystem.presentation.components.ResourceImage
import com.components.hospitalcaresystem.presentation.theme.md_theme_dark_outline
import com.components.hospitalcaresystem.presentation.theme.md_theme_light_background

@Composable
fun <T> ItemDoctor(
    modifier: Modifier = Modifier,
    modifierContent : Modifier = Modifier
        .size(55.dp)
        .padding(7.dp),
    image: T,
    title: String,
    description: String,
    containerColor : Color = MaterialTheme.colorScheme.primaryContainer,
    borderColor : Color = MaterialTheme.colorScheme.outline,
    shape: Shape = MaterialTheme.shapes.extraSmall,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(150.sdp)
            .height(150.sdp)
            .clickable { onClick() }, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HospitalCommonContainer(
            modifier = modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
            containerColor = md_theme_light_background,
            //borderColor = md_theme_dark_outline
            borderColor = MaterialTheme.colorScheme.primary
        ) {
            Column(modifier = Modifier.padding(vertical = 5.sdp, horizontal = 15.sdp), horizontalAlignment = Alignment.CenterHorizontally) {
                SpacerHeight(height = 10.sdp)
                ResourceImage(
                    modifier = Modifier
                        .size(100.sdp)
                        .padding(5.sdp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    image = image
                )
                Text(text = title, style = MaterialTheme.typography.labelLarge)
                Text(text = description, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
                SpacerHeight(height = 5.sdp)
            }
        }
    }
}


@Preview
@Composable
private fun PreviewItemDoctor() {
    ItemDoctor(
        image = R.drawable.img_doc1,
        title = "Dr.Sonia Khan",
        description = "Medical Specialist"
    )
}