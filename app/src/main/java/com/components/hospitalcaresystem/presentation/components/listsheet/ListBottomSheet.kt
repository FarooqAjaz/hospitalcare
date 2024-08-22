package com.components.hospitalcaresystem.presentation.components.listsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.sdp
import com.components.hospitalcaresystem.presentation.components.HospitalCareSearchField
import com.components.hospitalcaresystem.presentation.components.ResourceImage
import com.components.hospitalcaresystem.presentation.components.items.SheetItem
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * A composable function to display a custom bottom sheet with a list of items.
 *
 * @param items: The list of `T` type items to be displayed in the bottom sheet.
 * @param itemContent: A composable function that defines how each item should be displayed.
 *        It takes a single argument of type `T`.
 * @param isItemMatchingSearch: An optional lambda function that determines whether an item matches
 *        the search query. It takes two arguments: the item itself and the search query (String).
 *        If not provided, search functionality is disabled.
 * @param onItemClick: A callback function that is called when an item is clicked. It takes two arguments:
 *        the index of the clicked item (Int) and the item itself (T).
 * @param onSheetClose: A callback function that is called when the bottom sheet is closed.
 * @param title: The title of the bottom sheet (String).
 * @param description: An optional description text for the bottom sheet (String).
 * @param closeIcon: An optional composable function to display a close icon in the bottom sheet.
 * @param sheetState: The state of the bottom sheet. Defaults to a new `rememberModalBottomSheetState()`.
 * @param containerColor: Color of Sheet Background.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> ListBottomSheet(
    modifier: Modifier=Modifier,
    items: List<T>,
    itemContent: @Composable (T) -> Unit,
    isItemMatchingSearch: ((T, String) -> Boolean)? = null,
    onItemClick: (Int, T) -> Unit = { _, _ -> },
    onSheetClose: () -> Unit = {},
    title: String? = "",
    description: String? = null,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    sheetState: SheetState = rememberModalBottomSheetState(),
    closeIcon: @Composable (() -> Unit)? = {
        ResourceImage(image = R.drawable.ic_cross, modifier = Modifier
            .size(16.dp)
            .clickable {
                onSheetClose.invoke()
                coroutineScope.launch { sheetState.hide() }
            }
        )
    },
    containerColor: Color = MaterialTheme.colorScheme.background,
    dragHandle: @Composable (() -> Unit)? = null,
) {
    var searchText by remember { mutableStateOf("") }
    var filteredItems = items
    isItemMatchingSearch?.let { itemMatchingSearch ->
        filteredItems = items.filter { itemMatchingSearch(it, searchText) }
    }
    ModalBottomSheet(
        sheetState = sheetState,
        dragHandle = dragHandle,
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        modifier = modifier,
        content = {
            Column(
               Modifier.fillMaxWidth()
                    .padding(start = 10.sdp, end = 10.sdp, bottom = 20.sdp)
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    title?.let {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                    closeIcon?.invoke()
                }
                if (description != null) {
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                // FIXME:   Search bar
                isItemMatchingSearch?.let {
                    Spacer(modifier = Modifier.height(16.dp))
                    HospitalCareSearchField(onSearch = {
                        searchText = it
                    })
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Item list
                LazyColumn {
                    items(filteredItems.size) { index ->
                        val item = filteredItems[index]
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .clickable {
                                    onSheetClose()
                                    onItemClick(index, item)
                                    coroutineScope.launch { sheetState.hide() }
                                }
                        ) {
                            itemContent(item)
                        }
                    }
                }
            }
        },
        tonalElevation = 5.dp,
        containerColor = containerColor,
        windowInsets = WindowInsets.ime,
        onDismissRequest = {
            onSheetClose()
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, locale = "eng")
@Composable
fun PreviewHospitalTextInputFieldUrduLocale() {
    HospitalCareAppTheme(
        language = "eng"
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ListBottomSheet(
                title = "Select your country",
                items = TestDataHelper.getList(),
                itemContent = { item ->
                    SheetItem(
                        title = item.title,
                        leftIcon = Icons.Filled.AccountBox
                    )
                },
                isItemMatchingSearch = { item, query ->
                    item.title.contains(
                        query,
                        ignoreCase = true
                    )
                },
                sheetState = SheetState(
                    skipPartiallyExpanded = true,
                    density = LocalDensity.current,
                    initialValue = SheetValue.Expanded
                ),
            )
        }
    }
}


