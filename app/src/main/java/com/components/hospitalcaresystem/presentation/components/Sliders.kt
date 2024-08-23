package com.components.hospitalcaresystem.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.sdp
import kotlinx.coroutines.delay

/**
 * Composable function for displaying an slider pager with customizable content.
 * @param modifier: A Modifier to apply to the overall slider component.
 * @param list: A List of items to be displayed in the slider.
 * @param height: The desired height of the slider in Dp units. Defaults to 130.sdp.
 * @param delayMillis: The delay in milliseconds between automatic page transitions. Defaults to 2000 milliseconds.
 * @param isReverse: A boolean indicating the slider's direction. true for right-to-left, false for left-to-right. Defaults to true.
 * @param pagerState: A PagerState to control the slider's paging behavior. Defaults to a new PagerState with initial page 0 and page count based on the list size.
 * @param itemContent: A lambda that defines the content for each item in the slider. It receives the current item and its index as parameters.
 * @param indicator: An optional lambda that defines a custom indicator to be displayed below the slider.
 */
@Composable
fun <T> HospitalSlider(
    modifier: Modifier = Modifier,
    list: List<T>,
    height: Dp = 130.sdp,
    delayMillis: Long = 2000,
    isReverse: Boolean = true,
    pagerState: PagerState = rememberPagerState(initialPage = 0, pageCount = { list.size }),
    itemContent: @Composable (T, Int) -> Unit,
    indicator: @Composable (() -> Unit)? = null
) {

    LaunchedEffect(key1 = pagerState, key2 = list.size) {
        var scrollDirectionForward = true
        while (isReverse) {
            delay(delayMillis)
            val nextPage = when {
                list.size <= 1 -> 0 // Avoid unnecessary scrolling
                isReverse -> (pagerState.currentPage + 1) % list.size
                else -> when {
                    pagerState.currentPage == list.size - 1 -> {
                        scrollDirectionForward = false
                        pagerState.currentPage - 1
                    }

                    pagerState.currentPage == 0 -> {
                        scrollDirectionForward = true
                        pagerState.currentPage + 1
                    }

                    scrollDirectionForward -> pagerState.currentPage + 1
                    else -> pagerState.currentPage - 1
                }
            }
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.wrapContentSize()
    ) {
        HorizontalPager(
            state = pagerState, modifier = modifier
                .fillMaxWidth()
                .height(height)
        ) { page ->
            itemContent(list[page], page)
        }
        indicator?.invoke()

    }
}

@Composable
fun SliderIndicator(
    modifier: Modifier = Modifier,
    listSize: Int,
    pagerState: PagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { listSize }),
    onDotClick: (Int) -> Unit={}
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(listSize) { index ->
            Box(
                modifier = Modifier
                    .clickable { onDotClick(index) }
                    .clip(MaterialTheme.shapes.small)
                    .size(
                        width = 9.sdp,
                        height = 5.sdp,
                    )
                    .background(if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary else Color.Gray)
            )
            Spacer(modifier = Modifier.width(3.sdp))
        }
    }
}

@Preview
@Composable
fun SliderPreview() {
    val imageUrls = listOf(
        "https://fastly.picsum.photos/id/29/4000/2670.jpg?hmac=rCbRAl24FzrSzwlR5tL-Aqzyu5tX_PA95VJtnUXegGU",
        "https://fastly.picsum.photos/id/15/2500/1667.jpg?hmac=Lv03D1Y3AsZ9L2tMMC1KQZekBVaQSDc1waqJ54IHvo4",
        "https://fastly.picsum.photos/id/15/2500/1667.jpg?hmac=Lv03D1Y3AsZ9L2tMMC1KQZekBVaQSDc1waqJ54IHvo4",
        "https://fastly.picsum.photos/id/22/4434/3729.jpg?hmac=fjZdkSMZJNFgsoDh8Qo5zdA_nSGUAWvKLyyqmEt2xs0"
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { imageUrls.size })

    HospitalSlider(
        list = imageUrls,
        height = 100.sdp,
        delayMillis = 3000,
        isReverse = false,
        pagerState = pagerState,
        itemContent = { item, _ ->
            ResourceImage(
                modifier = Modifier
                    .fillMaxSize(),
                image = R.drawable.img_slider1,
                contentScale = ContentScale.FillBounds
            )
        },
        indicator = {
            SliderIndicator(listSize = imageUrls.size, pagerState = pagerState) { index ->
            }
        }
    )
}
