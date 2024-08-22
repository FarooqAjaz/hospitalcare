package com.components.hospitalcaresystem.presentation.components

import androidx.annotation.IntRange
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.MSISDNVisualTransformations
import com.components.hospitalcaresystem.extensions.hpr
import com.components.hospitalcaresystem.extensions.noRippleClickable
import com.components.hospitalcaresystem.extensions.sdp
import com.components.hospitalcaresystem.presentation.components.listsheet.ListBottomSheet
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.LocalDimensions
import com.components.hospitalcaresystem.presentation.theme.LocalShadows

/**
 * Description:
 * This file contains the Text Input field UI components, their layout, behavior, and
 * interaction logic used in the Hospital Care application.
 *
 **/

@Composable
fun HospitalCareTextInputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    fieldLabel: String = "",
    readOnly: Boolean = false,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    enableShadows: Boolean = true,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = MaterialTheme.colorScheme.primary,
        unfocusedBorderColor = MaterialTheme.colorScheme.primary
    ),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    transformation: VisualTransformation = VisualTransformation.None,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall,
    labelStyle: TextStyle = MaterialTheme.typography.labelLarge
) {
    val shadow = LocalShadows.current.medium
    Column(modifier = modifier) {
        if (fieldLabel.isNotEmpty()) {
            Text(
                text = fieldLabel,
                style = labelStyle
            )
            Spacer(modifier = Modifier.height(8.dp)) // Add 16dp space
        }
        Surface(
            modifier = if (enableShadows) {
                Modifier
                    .shadow(
                        elevation = shadow.elevation,
                        shape = MaterialTheme.shapes.small,
                        ambientColor = shadow.color
                    )
            } else {
                modifier
            }
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(LocalDimensions.current.hospitalInputFieldHeight)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer
                    ),
                value = value,
                shape = MaterialTheme.shapes.small,
                textStyle = textStyle,
                onValueChange = onValueChange,
                leadingIcon = leading,
                trailingIcon = trailing,
                placeholder = {
                    Text(
                        placeholder,
                        style = textStyle,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                visualTransformation = transformation,
                singleLine = singleLine,
                enabled = enabled,
                readOnly = readOnly,
                keyboardOptions = keyboardOptions,
                colors = colors
            )
        }


    }
}


/**
 * [HospitalCareOTPInputField] is a composable function for creating an OTP (One-Time Password) text field.
 *
 * @param value The current value of the OTP text field.
 * @param modifier Optional [Modifier] for configuring the layout behavior.
 * @param onTextChanged A callback triggered when the text in the OTP field changes.
 * @param numDigits The number of digits for the OTP. Default is 4.
 * @param textStyle The style configuration for the text within the digit containers.
 */
@Composable
fun HospitalCareOTPInputField(
    modifier: Modifier = Modifier,
    value: String,
    fieldLabel: String = "",
    @IntRange(from = 4, to = 6) numDigits: Int = 4,
    textStyle: TextStyle = MaterialTheme.typography.headlineSmall,
    labelStyle: TextStyle = MaterialTheme.typography.labelLarge,
    onTextChanged: (String) -> Unit,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        if (fieldLabel.isNotEmpty()) {
            Text(
                //modifier = Modifier.align(Alignment.Start),
                modifier = modifier,
                text = fieldLabel,
                style = labelStyle,
            )
            Spacer(modifier = Modifier.height(8.dp)) // Add 16dp space
        }
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr)
        {
            BasicTextField(
                modifier = Modifier
                    .wrapContentWidth(),
                value = value,
                onValueChange = {
                    if (it.length <= numDigits) {
                        onTextChanged(it)
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Done
                ),
                decorationBox = { _ ->
                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        repeat(numDigits) { index ->
                            val char = when {
                                index >= value.length -> ""
                                else -> value[index].toString()
                            }
                            val isEnabled = index < value.length

                            OutlinedDigitContainer(
                                modifier = Modifier
                                    .padding(horizontal = 4.dp),
                                digitBoxStyle = ContainerStyle.Outlined(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                                    unfocusedBorderColor = MaterialTheme.colorScheme.outline
                                ),
                                isMasked = true,
                                isFocused = isEnabled,
                                digit = char,
                                textStyle = textStyle,
                            )

                        }
                    }
                }
            )
        }
    }
}

/**
 * A private composable function representing an outlined digit container within the [HospitalCareOTPInputField].
 *
 * @param digitBoxStyle The style configuration for the digit container.
 * @param isMasked Whether to mask the digit.
 * @param isFocused Whether the digit container is currently focused.
 * @param digit The digit value.
 * @param mask A composable function for providing a custom masking visual for the digit.
 * @param textStyle The style configuration for the text within the digit container.
 * @param isError Whether the digit container is in an error state.
 */
@Composable
 fun OutlinedDigitContainer(
    modifier: Modifier = Modifier,
    digitBoxStyle: ContainerStyle.Outlined,
    isMasked: Boolean = true,
    isFocused: Boolean,
    digit: String,
    textStyle: TextStyle,
    isError: Boolean = false,
) {

    val animatedColor by animateColorAsState(
        targetValue = digitBoxStyle.borderColor(focused = isFocused, error = isError),
        label = "Border Color",
        animationSpec = tween(durationMillis = 200)
    )

    val animatedBorderWidth by animateDpAsState(
        targetValue = digitBoxStyle.borderWidth(focused = isFocused),
        label = "BorderWidth",
        animationSpec = tween(durationMillis = 200)
    )

    Box(
        modifier = modifier
            .size(LocalDimensions.current.pinFieldBoxSize)
            .clip(digitBoxStyle.shape)
            .border(
                width = animatedBorderWidth,
                color = animatedColor,
                shape = digitBoxStyle.shape
            )
            .background(
                color = digitBoxStyle.containerColor,
                shape = digitBoxStyle.shape
            )
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (digit.isEmpty()) "" else if (isMasked) "*" else digit,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 8.dp, bottom = 0.dp)
                .wrapContentHeight(),
            style = textStyle,
            textAlign = TextAlign.Center,
            maxLines = 1,
        )
    }
}


@Composable
fun HospitalCarePhoneFieldWithCountryIconAndCode(
    modifier: Modifier = Modifier,
    flag: Painter,
    code: String,
    enabled: Boolean = true,
    placeholder: String = "",
    value: String,
    fieldLabel: String = "",
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        if (fieldLabel.isNotEmpty()) {
            Text(
                text = fieldLabel,
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        /**
         * For fields like MSISDN input direction do not change for language change, hence
         * these fields will use local layout direction values
         */
        CompositionLocalProvider(
            LocalLayoutDirection provides LayoutDirection.Ltr
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Country code and flag field
                HospitalInputFieldContainer(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(end = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = flag, contentDescription = "",
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = code,
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }

                // Number input field
                HospitalCareTextInputField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = value,
                    enabled = enabled,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    transformation = MSISDNVisualTransformations.ThreeDigitCodeFollowedBySevenDigits,
                    placeholder = placeholder,
                    onValueChange = {
                        if (it != "0" && it.length <= 10) {
                            onValueChange(it)
                        }
                    },
                )
            }
        }
    }
}


@Composable
fun HospitalCareCNICFieldWithLabel(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: String = "",
    value: String,
    fieldLabel: String = "",
    trailing: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        if (fieldLabel.isNotEmpty()) {
            Text(
                text = fieldLabel,
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        HospitalCareTextInputField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value,
            enabled = enabled,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            transformation = MSISDNVisualTransformations.TransFormationForCnic,
            trailing = trailing,
            placeholder = placeholder,
            onValueChange = {
                if (it.length <= 13) {
                    onValueChange(it)
                }
            },
        )
    }
}

@ThemePreviews
@Composable
fun PreviewHospitalCareInputFieldsCatalog() {
    HospitalCareAppTheme {
        Surface {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = "Input Fields", modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )

                val text1 = remember { mutableStateOf("") }
                HospitalCareTextInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    value = text1.value,
                    onValueChange = { text1.value = it },
                    fieldLabel = "Enter mobile number",
                    placeholder = stringResource(id = R.string.enter_your_mobile_number)
                )



                val text2 = remember { mutableStateOf("") }
                HospitalCareTextInputField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    value = text1.value,
                    onValueChange = { text2.value = it },
                    fieldLabel = "Category",
                    placeholder = "Select Category",
                    trailing = { ResourceIcon(icon = R.drawable.ic_arrow_without_tail)}
                )


                val pinValue = remember { mutableStateOf("") }
                val pinValue1 = remember { mutableStateOf("") }
                HospitalCareOTPInputField(
                    modifier = Modifier.padding(top = 20.dp),
                    value = pinValue.value,
                    fieldLabel = "Enter Pin",
                    numDigits = 5,
                    onTextChanged = {
                        pinValue.value = it
                    })

                HospitalCareOTPInputField(
                    modifier = Modifier.padding(top = 8.dp),
                    value = pinValue1.value,
                    onTextChanged = {
                        pinValue1.value = it
                    })

                val text = remember { mutableStateOf("") }
                HospitalCarePhoneFieldWithCountryIconAndCode(
                    modifier = Modifier.padding(top = 20.dp),
                    flag = painterResource(id = R.drawable.ic_pakistan_flag),
                    code = "+92",
                    placeholder = "300 0000000",
                    fieldLabel = "Enter mobile number",
                    value = text.value
                ) {
                    text.value = it
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T>InputFieldWithBottomSheet(
    sheetList: List<T> = emptyList(),
    fieldLabel : String = stringResource(id = R.string.select_category),
    placeholder: String,
    selectedItem: String = "",
    itemContent: @Composable (T) -> Unit,
    onItemClick: (Int, T) -> Unit = { _, _ -> },
    onSheetClose:  () -> Unit = {},
    isItemMatchingSearch: ((T, String) -> Boolean)? = null,
    sheetState: SheetState = rememberModalBottomSheetState(),
    fieldLabelClick : () -> Unit = {}
){
    AnimatedVisibility(visible = sheetState.isVisible) {
        ListBottomSheet(
            modifier = Modifier.heightIn(min = 50.hpr, max = 100.hpr),
            title = fieldLabel,
            items = sheetList,
            itemContent = itemContent,
            onItemClick = onItemClick,
            onSheetClose = onSheetClose,
            isItemMatchingSearch = isItemMatchingSearch,
            sheetState = sheetState,
        )
    }
    HospitalCareTextInputField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.sdp),
        readOnly = true,
        value = selectedItem,
        onValueChange = {},
        fieldLabel = fieldLabel,
        placeholder = placeholder,
        trailing = {
            ResourceIcon(
                icon = R.drawable.ic_arrow_without_tail,
                modifier = Modifier.noRippleClickable { fieldLabelClick.invoke() }
            )
        }
    )
}


@ThemePreviews
@Composable
fun PreviewOTPField() {
    HospitalCareAppTheme {
        Surface {
            val pinValue = remember { mutableStateOf("") }
            HospitalCareOTPInputField(
                modifier = Modifier.padding(16.dp),
                value = pinValue.value,
                onTextChanged = {
                    pinValue.value = it
                })
        }
    }
}