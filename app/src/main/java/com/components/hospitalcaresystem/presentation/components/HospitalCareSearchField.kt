package com.components.hospitalcaresystem.presentation.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.sdp

/**
 * A composable function to create a custom search field.
 *
 * @param modifier: Modifier for styling the search field (default: Modifier).
 * @param onSearch: A callback function that is called when the user performs a search
 *        action (e.g., pressing enter on the keyboard).
 * @param hint: The hint text displayed when the field is empty (default: "Search...").
 * @param prefix: An optional composable function to display a leading icon before the search field.
 *        Defaults to a Search icon using Icons.Outlined.Search.
 * @param suffix: An optional composable function to display a trailing icon after the search field.
 *        Defaults to null.
 * @param shape: The shape of the search field (default: RoundedCornerShape(10.dp)).
 * @param placeholder: An optional composable function to display a placeholder within the search field
 *        when it's empty. Defaults to a `SearchPlaceHolder` composable with the provided hint text.
 */
@Composable
fun HospitalCareSearchField(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit,
    hint: String = "Search...",
    prefix: @Composable (() -> Unit)? = { HintResourceIcon(icon = R.drawable.ic_search, modifier = Modifier.padding(end = 5.sdp)) },
    suffix: @Composable (() -> Unit)? = null,
    shape: Shape = RoundedCornerShape(10.dp),
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    placeholder: @Composable (() -> Unit)? = { SearchPlaceHolder(hint = hint) },
) {
    var textState by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = textState,
        onValueChange = { value ->
            textState = value
            onSearch(value.text)
        },
        prefix = prefix,
        suffix = suffix,
        shape = shape,
        textStyle = textStyle,
        placeholder = placeholder,
        modifier = modifier
            .fillMaxWidth(),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.surfaceDim
        )
    )
}

@Preview(name = "CustomSearchField")
@Composable
private fun PreviewCustomSearchField() {
    HospitalCareSearchField(onSearch = {
        println(it)
    })
}