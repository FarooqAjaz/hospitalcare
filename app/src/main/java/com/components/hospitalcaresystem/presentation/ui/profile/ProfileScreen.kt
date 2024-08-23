package com.components.hospitalcaresystem.presentation.ui.profile

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.SpacerHeight
import com.components.hospitalcaresystem.extensions.SpacerWidth
import com.components.hospitalcaresystem.extensions.sdp
import com.components.hospitalcaresystem.presentation.components.HospitalCommonContainer
import com.components.hospitalcaresystem.presentation.components.ResourceImage
import com.components.hospitalcaresystem.presentation.components.ScreenContainer
import com.components.hospitalcaresystem.presentation.components.StarRatingBar
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.StatusBarColor
import com.components.hospitalcaresystem.presentation.theme.md_theme_light_background

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
        var rating by remember { mutableStateOf(3f) } //default rating will be 1

        Column(Modifier.fillMaxWidth()) {
            SpacerHeight(height = 10.sdp)
            HospitalCommonContainer {
                HospitalCommonContainer(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.small,
                    containerColor = md_theme_light_background,
                    borderColor = MaterialTheme.colorScheme.primary
                ) {
                    Row(modifier = Modifier.padding(vertical = 5.sdp, horizontal = 10.sdp)) {
                        ResourceImage(
                            modifier = Modifier
                                .size(100.sdp)
                                .padding(5.sdp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                            image = R.drawable.img_patient
                        )
                        SpacerWidth(width = 10.sdp)
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.sdp)) {
                            Text(text = "Does Jhon", style = MaterialTheme.typography.labelLarge,color = MaterialTheme.colorScheme.primary)
                            SpacerHeight(height = 5.sdp)
                            Text(text = "Heart Patient", style = MaterialTheme.typography.labelMedium)
                            SpacerHeight(height = 5.sdp)
                            Text(text = "Dir Lower KPK,Timergara", style = MaterialTheme.typography.labelMedium)
                        }
                    }
                }
            }
            SpacerHeight(height = 20.sdp)
            Text(text = "Medications:", style = MaterialTheme.typography.headlineSmall,color = MaterialTheme.colorScheme.primary)

            SpacerHeight(height = 10.sdp)
            MedicationsTableScreen()

            SpacerHeight(height = 10.sdp)
            Text(text = "Investigation:", style = MaterialTheme.typography.headlineSmall,color = MaterialTheme.colorScheme.primary)

            SpacerHeight(height = 10.sdp)
            InvestigationTable()

            SpacerHeight(height = 10.sdp)
            Text(text = "Next Visit:", style = MaterialTheme.typography.headlineSmall,color = MaterialTheme.colorScheme.primary)

            SpacerHeight(height = 10.sdp)
            Text(text = "Visit Type:", style = MaterialTheme.typography.headlineSmall,color = MaterialTheme.colorScheme.primary)

            SpacerHeight(height = 10.sdp)
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                ResourceImage(
                    modifier = Modifier
                        .size(100.sdp)
                        .padding(5.sdp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    image = R.drawable.img_help
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row (Modifier.fillMaxWidth()){
                ResourceImage(
                    modifier = Modifier,
                    image = R.drawable.ic_info,
                )
                SpacerWidth(width = 5.sdp)
                Text(
                    text = "When you press the Help button, a notification will be sent to the Emergency Unit.",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            SpacerHeight(height = 10.sdp)
        }
    }
}

@Composable
fun InvestigationTable() {
    // Just a fake data... a Pair of Int and String
    val tableData = (1..1).mapIndexed { index, item ->
        index to ""
    }
    // Each cell of a column must have the same weight.
    val column1Weight = .6f // 60%
    val column2Weight = .2f // 20%
    val column3Weight = .2f // 20%
    // The LazyColumn will be our table. Notice the use of the weights below
    LazyColumn(Modifier.fillMaxWidth()) {
        // Here is the header
        item {
            Row(Modifier.background(Color.White)) {
                TableCell(text = "Test Name", weight = column1Weight)
                TableCell(text = "Urgent", weight = column2Weight)
                TableCell(text = "Fasting", weight = column3Weight)
            }
        }
        // Here are all the lines of your table.
        items(tableData) {
            val (id, text) = it
            Row(Modifier.fillMaxWidth()) {
                TableCell(text = "", weight = column1Weight)
                TableCell(text = text, weight = column2Weight)
                TableCell(text = text, weight = column3Weight)
            }
        }
    }
}

@Composable
fun MedicationsTableScreen() {
    // Just a fake data... a Pair of Int and String
    val tableData = (1..4).mapIndexed { index, item ->
        index to ""
    }
    // Each cell of a column must have the same weight.
    val column1Weight = .1f // 10%
    val column2Weight = .5f // 50%
    val column3Weight = .4f // 40%
    // The LazyColumn will be our table. Notice the use of the weights below
    LazyColumn(Modifier.fillMaxWidth()) {
        // Here is the header
        item {
            Row(Modifier.background(Color.White)) {
                TableCell(text = "#", weight = column1Weight)
                TableCell(text = "Prescription", weight = column2Weight)
                TableCell(text = "", weight = column3Weight)
            }
        }
        // Here are all the lines of your table.
        items(tableData) {
            val (id, text) = it
            Row(Modifier.fillMaxWidth()) {
                TableCell(text = id.toString(), weight = column1Weight)
                TableCell(text = text, weight = column2Weight)
                TableCell(text = text, weight = column3Weight)
            }
        }
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
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