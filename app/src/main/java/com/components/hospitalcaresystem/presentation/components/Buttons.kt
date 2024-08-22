package com.components.hospitalcaresystem.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.LocalDimensions
import com.components.hospitalcaresystem.presentation.theme.Orange90

/**
 *
 * Description:
 * This file contains the Button UI components, their layout, behavior, and
 * interaction logic used in the Hospital application.
 *
 **/

@Composable
fun HospitalCareButton(
    modifier: Modifier,
    primary: Boolean = true,
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    if (primary) {
        Button(
            modifier = modifier.height(LocalDimensions.current.buttonHeight),
            onClick = onClick,
            enabled = enabled,
            shape = MaterialTheme.shapes.small
        ) {
            content()
        }
    } else {
        OutlinedButton(
            modifier = modifier.height(LocalDimensions.current.buttonHeight),
            onClick = onClick,
            enabled = enabled,
            colors = ButtonDefaults.outlinedButtonColors().copy(
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            border = BorderStroke(
                width = LocalDimensions.current.buttonBorderWidth,
                color = MaterialTheme.colorScheme.primary,
            ),
            shape = MaterialTheme.shapes.small
        ) {
            content()
        }
    }
}

@Composable
fun HospitalCareTextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    primary: Boolean = true,
    onClick: () -> Unit,
) {
    HospitalCareButton(
        modifier = modifier,
        primary = primary,
        enabled = enabled,
        content = {
            Text(
                text = text, style = MaterialTheme.typography.titleMedium
            )
        },
        onClick = onClick
    )
}



@Composable
fun HospitalCareIconButton(
    modifier: Modifier = Modifier,
    iconPainter: Painter,
    contentDescription: String = "",
    enabled: Boolean = true,
    primary: Boolean = true,
    onClick: () -> Unit
) {
    HospitalCareButton(
        modifier = modifier,
        primary = primary,
        content = {
            Icon(painter = iconPainter, contentDescription = contentDescription)
        },
        enabled = enabled,
        onClick = onClick
    )
}



@Composable
fun HospitalCareTextButton(
    modifier: Modifier = Modifier,
    iconPainter: Painter,
    contentDescription: String = "",
    title: String = "",
    tint: Color = LocalContentColor.current,
    primary: Boolean = true,
    enabled: Boolean = true,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
    onClick: () -> Unit,
) {
    HospitalCareButton(
        enabled = enabled,
        primary = primary,
        modifier = modifier,
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = horizontalArrangement
            ) {
                if (horizontalArrangement == Arrangement.Center) {
                    Icon(
                        painter = iconPainter,
                        contentDescription = contentDescription,
                        modifier = Modifier.padding(end = 8.dp),
                        tint = tint
                    )
                    Text(
                        text = title, style = MaterialTheme.typography.titleMedium
                    )
                } else {
                    Text(text = title, style = MaterialTheme.typography.titleMedium)
                    Icon(painter = iconPainter, contentDescription = contentDescription)
                }

            }

        },
        onClick = onClick
    )
}

@Composable
fun HospitalCareIconTextPrimaryButton(
    modifier: Modifier = Modifier,
    iconPainter: Painter,
    contentDescription: String = "",
    title: String = "",
    tint: Color = LocalContentColor.current,
    enabled: Boolean = true,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
    onClick: () -> Unit,
) {
    HospitalCareTextButton(
        modifier = modifier,
        iconPainter = iconPainter,
        contentDescription = contentDescription,
        title = title,
        tint = tint,
        horizontalArrangement = horizontalArrangement,
        enabled = enabled,
        onClick = onClick
    )
}

@Composable
fun HospitalCareIconTitleWithDescriptionCard(
    modifier: Modifier = Modifier,
    icon: @Composable() () -> Unit,
    title: @Composable() () -> Unit,
    description: @Composable() () -> Unit,
    onClick: () -> Unit,
){
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        onClick = onClick,
        border = BorderStroke(1.dp, Color.Black),
        modifier = modifier,
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            icon()
            Column {
                title()
                description()
            }
        }
    }
}


@Composable
fun HospitalCareNextButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    primary: Boolean = true,
    title: String = stringResource(id = R.string.next),
    onClick: () -> Unit,
) {
    HospitalCareTextButton(
        modifier = modifier,
        primary = primary,
        iconPainter = painterResource(id = R.drawable.ic_arrow_right),
        title = title,
        contentDescription = "",
        enabled = enabled,
        onClick = onClick
    )
}

//TODO : TextColor is not mentioned if primary color is false
@Composable
fun HospitalCareLogoutButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    primary: Boolean = false,
    onClick: () -> Unit,
) {
    HospitalCareTextButton(
        modifier = modifier,
        primary = primary,
        iconPainter = painterResource(id = R.drawable.ic_logout),
        tint = Orange90,
        title = stringResource(id = R.string.logout),
        contentDescription = "",
        horizontalArrangement = Arrangement.Center,
        enabled = enabled,
        onClick = onClick
    )

}

@ThemePreviews
@Composable
fun PreviewButtonsCatalog() {
    HospitalCareAppTheme {
        Surface {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = "Buttons", modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )

                Text(
                    text = "Buttons with Text and Icon", modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )

                Text(
                    text = "Buttons with spaced alignment", modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    style = TextStyle.Default.copy(color = Color.Gray)
                )
                HospitalCareNextButton(
                    modifier = Modifier.padding(top = 8.dp)
                ) {

                }
                HospitalCareNextButton(
                    primary = false,
                    modifier = Modifier.padding(top = 8.dp)
                ) {

                }
                HospitalCareNextButton(
                    enabled = false,
                    modifier = Modifier.padding(top = 8.dp)
                ) {

                }

                Text(
                    text = "Buttons with center alignment", modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    style = TextStyle.Default.copy(color = Color.Gray)
                )
                HospitalCareLogoutButton(
                    modifier = Modifier.padding(top = 8.dp)
                ) {

                }


                Text(
                    text = "Text Buttons", modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )

                HospitalCareTextButton(
                    text = "Next",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {

                }

                Text(
                    text = "Small Button", modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )

                HospitalCareButton(
                    modifier = Modifier.height(30.dp),
                    primary = true,
                    enabled = true,
                    content = {
                        Text(
                            text = "Next", style = MaterialTheme.typography.labelMedium
                        )
                    },
                    onClick ={

                    }
                )

                Text(
                    text = "Icon with Title and Description",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    HospitalCareIconTitleWithDescriptionCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        title = { Text(text = "Title") },
                        description = { Text(text = "Descrip") },
                        icon = { Icon(painter = painterResource(id = R.drawable.ic_logout), contentDescription = "an") }
                    ){

                    }
                    HospitalCareIconTitleWithDescriptionCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        title = { Text(text = "Title2") },
                        description = { Text(text = "Descrip2") },
                        icon = { Icon(painter = painterResource(id = R.drawable.ic_logout), contentDescription = "an") }
                    ){

                    }
                }

            }
        }
    }
}
