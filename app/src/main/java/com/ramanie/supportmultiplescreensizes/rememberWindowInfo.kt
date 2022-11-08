package com.ramanie.supportmultiplescreensizes

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberWindowInfo(): WindowInfo{
    val configuration = LocalConfiguration.current
    return WindowInfo(
        screenWidthInfo = when {
            configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenHeightInfo = when {
            configuration.screenWidthDp < 480 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 900 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenHeight = configuration.screenHeightDp.dp,
        screenWidth = configuration.screenWidthDp.dp
    )
}

// this data class will allow us to share info abt the current device's screen
data class WindowInfo(
    val screenWidthInfo: WindowType,
    val screenHeightInfo: WindowType,
    val screenWidth: Dp,
    val screenHeight: Dp
){
    // android has 3 types of screens : 1. Compact - these are the smallest screens and usually have a max width of 600dp
    // 2. Medium - these are screens with a width of btwn 600dp and 840dp(the smaller tablets)
    // 3. Expanded - these are the largest screens supported by android with a width of 840dp plus
    sealed class WindowType{
        object Compact: WindowType()
        object Medium: WindowType()
        object Expanded: WindowType()
    }
}