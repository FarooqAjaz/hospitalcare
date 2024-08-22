package com.components.hospitalcaresystem.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.SpacerHeight
import com.components.hospitalcaresystem.extensions.sdp
import com.components.hospitalcaresystem.presentation.theme.BORDER_GRAY
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.LightOrange40
import com.components.hospitalcaresystem.presentation.theme.LightOrange60
import com.components.hospitalcaresystem.presentation.theme.LocalDimensions
import com.components.hospitalcaresystem.presentation.theme.LocalShadows
import com.components.hospitalcaresystem.presentation.theme.Shadow

/**
 * This file contains all the cards used in Hospital Care Application
 *
 **/

//TODO: Use card name instead of container.
/**
 * `ContainerStyle` is a sealed class representing different styles for displaying containers
 * This class provides a flexible way to customize the appearance of containers in Hospital Care Application.
 *
 * @property containerColor The background color of the digit container.
 * @property focusedBorderColor The border color when the digit container is focused.
 * @property unfocusedBorderColor The border color when the digit container is not focused.
 * @property focusedBorderWidth The border width when the digit container is focused.
 * @property unfocusedBorderWidth The border width when the digit container is not focused.
 * @property errorColor The color used to indicate an error state in the digit container.
 */
sealed class ContainerStyle(
    open val containerColor: Color = Color.Unspecified,
    open val focusedBorderColor: Color = Color.Unspecified,
    open val unfocusedBorderColor: Color = Color.Unspecified,
    open val enabledBorderColor: Color = Color.Unspecified,
    open val disabledBorderColor: Color = Color.Unspecified,
    open val enabledContentColor: Color = Color.Unspecified,
    open val disabledContentColor: Color = Color.Unspecified,
    open val focusedBorderWidth: Dp = 2.dp,
    open val unfocusedBorderWidth: Dp = 2.dp,
    open val errorColor: Color = Color.Unspecified,
    open val shape: Shape = RoundedCornerShape(8.dp),
    open val shadow: Shadow = Shadow(elevation = 1.dp, color = Color.Black)
) {

    /**
     * Returns the appropriate border width based on the focus state of the digit container.
     *
     * @param focused Whether the digit container is currently focused.
     * @return The border width to be used for the digit container.
     */
    fun borderWidth(focused: Boolean): Dp {
        return if (focused) focusedBorderWidth else unfocusedBorderWidth
    }

    /**
     * Returns the appropriate border color based on the focus and error states of the digit container.
     *
     * @param focused Whether the digit container is currently focused.
     * @param error Whether the digit container is in an error state.
     * @return The border color to be used for the digit container.
     */
    fun borderColor(focused: Boolean, error: Boolean): Color {
        return when {
            error -> errorColor
            focused -> focusedBorderColor
            else -> unfocusedBorderColor
        }
    }

    /**
     * Represents an outlined style for the digit container of our
     *
     * @property size The size of the digit container.
     * @property shape The shape of the digit container.
     */
    data class Outlined(
        override val shadow: Shadow = Shadow(elevation = 1.dp, color = Color.Black),
        override val shape: Shape = RoundedCornerShape(12.dp),
        override val containerColor: Color = Color.Unspecified,
        override val focusedBorderColor: Color = Color.Unspecified,
        override val unfocusedBorderColor: Color = Color.Unspecified,
        override val enabledBorderColor: Color = Color.Unspecified,
        override val disabledBorderColor: Color = Color.Unspecified,
        override val enabledContentColor: Color = Color.Unspecified,
        override val disabledContentColor: Color = Color.Unspecified,
        override val focusedBorderWidth: Dp = 1.0.dp,
        override val unfocusedBorderWidth: Dp = 0.8.dp,
        override val errorColor: Color = Color.Unspecified,
    ) : ContainerStyle(
        containerColor = containerColor,
        focusedBorderColor = focusedBorderColor,
        unfocusedBorderColor = unfocusedBorderColor,
        unfocusedBorderWidth = unfocusedBorderWidth,
        focusedBorderWidth = focusedBorderWidth,
        errorColor = errorColor
    )
}

@Composable
fun HospitalContainer(
    modifier: Modifier,
    enabled: Boolean = true,
    style: ContainerStyle,
    content: @Composable () -> Unit,
) {
    MaterialTheme.shapes.small
    Surface(
        modifier = modifier.shadow(
            elevation = style.shadow.elevation,
            shape = style.shape,
            ambientColor = style.shadow.color
        ),
        shape = style.shape,
        border = BorderStroke(
            width = 1.dp,
            color = if (enabled) style.enabledBorderColor else style.disabledBorderColor
        ),
        color = style.containerColor,
        contentColor = if (enabled) style.enabledContentColor else style.disabledContentColor
    ) {
        content()
    }
}


// Wrapper for MaterialCard WIth Icon
@Composable
fun <T> HospitalContainerWithIcon(
    icon: T,
    modifier: Modifier = Modifier,
    modifierContent: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.extraSmall,
    style: ContainerStyle = ContainerStyle.Outlined(
        enabledBorderColor = MaterialTheme.colorScheme.outline,
        disabledBorderColor = MaterialTheme.colorScheme.outline,
        enabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        disabledContentColor = MaterialTheme.colorScheme.surfaceVariant,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        shape = shape
    ),
) {
    HospitalContainer(modifier = modifier, enabled = enabled, style = style, content = {
        ResourceImage(image = icon, modifier = modifierContent)
    })
}

// Wrapper for MaterialCard Icon and text for dashboard
@Composable
fun <T> HospitalContainerIconWithText(
    icon: T,
    modifier: Modifier = Modifier,
    modifierContent: Modifier = Modifier,
    spacer: Dp = 5.sdp,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    horizontalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    textContent: (@Composable () -> Unit)? = null,
    style: ContainerStyle = ContainerStyle.Outlined(
        enabledBorderColor = BORDER_GRAY,
        disabledBorderColor = BORDER_GRAY,
        enabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        disabledContentColor = MaterialTheme.colorScheme.surfaceVariant,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        shape = MaterialTheme.shapes.small
    ),
) {
    HospitalContainer(modifier = modifier, enabled = true, style = style, content = {
        Row(
            modifier = modifierContent.fillMaxSize(),
            verticalAlignment = verticalAlignment,
            horizontalArrangement = horizontalArrangement
        ) {
            ResourceImage(image = icon)
            Spacer(modifier = Modifier.width(spacer))
            textContent?.invoke()
        }
    })
}


@Composable
fun HospitalInputFieldContainer(
    modifier: Modifier,
    enabled: Boolean = true,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    content: @Composable () -> Unit,
) {
    HospitalContainer(
        modifier = modifier.height(LocalDimensions.current.hospitalInputFieldHeight),
        enabled = enabled,
        style = ContainerStyle.Outlined(
            enabledBorderColor = MaterialTheme.colorScheme.primary,
            disabledBorderColor = MaterialTheme.colorScheme.primary,
            enabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.surfaceVariant,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.small
        ),
        /*shadow = LocalShadows.current.medium,
        shape = shape*/
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = horizontalArrangement
        ) {
            content()
        }
    }
}

@Composable
fun HospitalPrimaryContainer(
    modifier: Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) {
    HospitalContainer(
        modifier = modifier, enabled = enabled, style = ContainerStyle.Outlined(
            enabledBorderColor = MaterialTheme.colorScheme.outline,
            disabledBorderColor = MaterialTheme.colorScheme.primary,
            enabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.surfaceVariant,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.medium,
            shadow = LocalShadows.current.medium,
        ), content = content
    )
}

@Composable
fun HospitalInfoContainer(
    modifier: Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) {
    HospitalContainer(
        modifier = modifier, enabled = enabled, style = ContainerStyle.Outlined(
            enabledBorderColor = MaterialTheme.colorScheme.outline,
            disabledBorderColor = MaterialTheme.colorScheme.primary,
            enabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.surfaceVariant,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.medium,
            shadow = LocalShadows.current.medium,
        ), content = content
    )
}

@Composable
fun HospitalindigiAlertContainer(
    modifier: Modifier,
    enabled: Boolean = true,
    shape: CornerBasedShape = MaterialTheme.shapes.medium,
    content: @Composable () -> Unit,
) {
    HospitalContainer(
        modifier = modifier, enabled = enabled, style = ContainerStyle.Outlined(
            enabledBorderColor = LightOrange60,
            disabledBorderColor = MaterialTheme.colorScheme.primary,
            enabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.surfaceVariant,
            containerColor = LightOrange40,
            shape = shape,
            shadow = LocalShadows.current.medium,
        ), content = content
    )
}


@Composable
fun HospitalCommonContainer(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    shadow: Shadow = LocalShadows.current.medium,
    borderColor: Color = MaterialTheme.colorScheme.outline,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    content: @Composable () -> Unit,
) {
    HospitalContainer(
        modifier = modifier,
        style = ContainerStyle.Outlined(
            enabledBorderColor = borderColor,
            disabledBorderColor = MaterialTheme.colorScheme.primary,
            enabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.surfaceVariant,
            containerColor = containerColor,
            shape = shape,
            shadow = shadow,
        ), content = content
    )
}

@Composable
fun ContainerOrange(modifier: Modifier, content: @Composable () -> Unit) {
    HospitalCommonContainer(modifier = modifier,
        borderColor = LightOrange60,
        containerColor = LightOrange40,
        content = {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                content()
            }
        })
}


@ThemePreviews
@Composable
fun PreviewContainerCatalog() {
    HospitalCareAppTheme {
        Surface {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Cards", modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )

                Text(
                    text = "Input Field", modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )

                HospitalInputFieldContainer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Text(text = "What is up!!")
                }

                HospitalInputFieldContainer(
                    enabled = false, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Text(text = "What is up!!")
                }

                Text(
                    text = "Primary Card", modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )

                HospitalPrimaryContainer(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(50.dp, 50.dp)
                ) {

                }

                HospitalindigiAlertContainer(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(50.dp, 50.dp)
                ) {

                }
                Spacer(modifier = Modifier.height(5.dp))
                HospitalContainerWithIcon(
                    icon = R.drawable.ic_android,
                    modifierContent = Modifier
                        .size(35.dp)
                        .padding(7.dp)
                )
                HospitalContainerIconWithText(icon = R.drawable.ic_android,
                    modifier = Modifier
                        .height(45.sdp)
                        .padding(7.dp),
                    textContent = {
                        Column {
                            Text(text = "Credit", style = MaterialTheme.typography.labelSmall)
                            Text(text = "Rs.10000", style = MaterialTheme.typography.labelLarge)
                        }
                    })
                SpacerHeight(height = 5.sdp)
                HospitalCommonContainer(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.sdp), content = {
                    ResourceImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable { },
                        image = R.drawable.ic_android,
                        contentScale = ContentScale.FillBounds
                    )
                })
                SpacerHeight(height = 5.sdp)
                ContainerOrange(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.sdp)
                ) {
                    Text(text = "Pakistan Stocks Exchange")
                }
            }
        }
    }
}