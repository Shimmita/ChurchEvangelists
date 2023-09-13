package com.shimitadouglas.uet.bottom

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItemState(
    val title:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean,
    val badgeCount: Int? = null
)