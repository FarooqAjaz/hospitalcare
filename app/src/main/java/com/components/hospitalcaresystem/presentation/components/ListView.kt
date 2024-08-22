package com.components.hospitalcaresystem.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class LayoutType {
    VERTICAL, HORIZONTAL, GRID
}

/**
 *
 * @param items: A List of items to be displayed in the list.
 * @param itemContent: A lambda that defines the content for each item in the list. It receives the current item and its index as parameters.
 * @param modifier: A Modifier to apply to the list component.
 * @param layoutType: Specifies the layout type for the list. Can be either LayoutType.VERTICAL or LayoutType.GRID.
 * @param gridSpanCount: The number of columns for grid layout. Only applicable when layoutType is LayoutType.GRID. Defaults to 3.
 * @param horizontalArrangement: Defines the arrangement of items in a horizontal row.
 * @param verticalArrangement: Defines the arrangement of items in a vertical column
 */
@Composable
fun <T> HospitalCareList(
    items: List<T>,
    itemContent: @Composable (T, Int) -> Unit,
    modifier: Modifier = Modifier,
    layoutType: LayoutType = LayoutType.VERTICAL,
    gridSpanCount: Int = 3,
    isNestedItem: Boolean = false,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalArrangement: Arrangement.Vertical = Arrangement.Bottom,
) {
    when (layoutType) {
        LayoutType.VERTICAL -> {
            if (isNestedItem) {
                Column(modifier = modifier, verticalArrangement = verticalArrangement) {
                    items.forEachIndexed { pos, item ->
                        ListItem(
                            item = item,
                            position = pos,
                            itemContent = itemContent,
                        )
                    }
                }
            } else {
                LazyColumn(modifier = modifier, verticalArrangement = verticalArrangement) {
                    itemsIndexed(items) { pos, item ->
                        ListItem(
                            item = item,
                            position = pos,
                            itemContent = itemContent,
                        )
                    }
                }
            }

        }

        LayoutType.HORIZONTAL -> {
            if (isNestedItem) {
                Row(modifier = modifier, horizontalArrangement = horizontalArrangement) {
                    items.forEachIndexed { pos, item ->
                        ListItem(
                            item = item,
                            position = pos,
                            itemContent = itemContent,
                        )
                    }
                }
            } else {
                LazyRow(modifier = modifier, horizontalArrangement = horizontalArrangement) {
                    itemsIndexed(items) { pos, item ->
                        ListItem(
                            item = item, position = pos, itemContent = itemContent
                        )
                    }
                }
            }
        }

        LayoutType.GRID -> {
            if (isNestedItem) {
                Row(modifier = modifier, horizontalArrangement = horizontalArrangement) {
                    items.forEachIndexed { pos, item ->
                        ListItem(
                            item = item,
                            position = pos,
                            itemContent = itemContent,
                        )
                    }
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(gridSpanCount),
                    horizontalArrangement = horizontalArrangement,
                    verticalArrangement = verticalArrangement,
                    modifier = modifier
                ) {
                    itemsIndexed(items) { pos, item ->
                        ListItem(
                            item = item, position = pos, itemContent = itemContent
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun <T> ListItem(
    item: T, position: Int = 0, itemContent: @Composable (T, Int) -> Unit
) {
    itemContent(item, position)
}

@Preview(name = "ListPreview")
@Composable
private fun HorizontalListPreview() {
    val items = listOf("Item 1", "Item 2", "Item 3")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        HospitalCareList(
            items = items,
            layoutType = LayoutType.HORIZONTAL,
            itemContent = { item, _ ->
                Box(modifier = Modifier.padding(5.dp)) {
                    Text(text = item, modifier = Modifier.fillMaxWidth())
                }
            },
        )
    }
}

@Preview(name = "ListPreview")
@Composable
private fun VerticalListPreview() {
    val items = listOf("Item 1", "Item 2", "Item 3")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HospitalCareList(
            items = items,
            itemContent = { item, pos ->
                Box(modifier = Modifier.padding(vertical = 5.dp)) {
                    Text(text = item, modifier = Modifier.fillMaxWidth())
                }
            },
        )
    }
}

@Preview(name = "ListPreview")
@Composable
private fun GridListPreview() {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HospitalCareList(
            items = items,
            layoutType = LayoutType.GRID,
            gridSpanCount = 3,
            itemContent = { item, _ ->
                Box(modifier = Modifier.padding(vertical = 5.dp)) {
                    Text(text = item, modifier = Modifier.fillMaxWidth())
                }
            },
        )
    }
}