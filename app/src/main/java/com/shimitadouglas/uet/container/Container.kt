package com.shimitadouglas.uet.container

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.shimitadouglas.uet.R
import com.shimitadouglas.uet.bottom.BottomNavItemState
import com.shimitadouglas.uet.routes.Routes
import com.shimitadouglas.uet.screens.bottom.Home
import com.shimitadouglas.uet.screens.bottom.Members
import com.shimitadouglas.uet.screens.bottom.Notification
import com.shimitadouglas.uet.screens.bottom.Profile
import com.shimitadouglas.uet.topbar.TopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Container(navigationController: NavHostController, context: Context) {
    //declaring array of BottomNavItemStates
    val items = arrayListOf(
        //homeState
        BottomNavItemState(
            title = Routes.HOME_SCREEN,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasBadge = false
        ),
        //members state
        BottomNavItemState(
            title = Routes.MEMBERS_SCREEN,
            selectedIcon = Icons.Filled.Face,
            unselectedIcon = Icons.Outlined.Face,
            hasBadge = false
        ),
        //NotificationState
        BottomNavItemState(
            Routes.NOTIFICATION_SCREEN,
            Icons.Filled.Notifications,
            Icons.Outlined.Notifications,
            hasBadge = true,
            10
        ),
        //AccountProfileState
        BottomNavItemState(
            title = Routes.PROFILE_SCREEN,
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle,
            hasBadge = false
        )
    )

    //declaring index holder
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        //topBar
        topBar = {
            TopBar(title = stringResource(id = R.string.app_name_full))
        },
        //bottom  bar
        bottomBar = {
            NavigationBar(tonalElevation = 50.dp) {
                //looping through the items
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = { selectedItemIndex = index },
                        icon = {
                            BadgedBox(badge = {
                                if (item.hasBadge && item.badgeCount!! > 0)
                                    Badge {

                                        Text(text = item.badgeCount.toString())
                                    }
                            }) {
                                //assign icon based on if the item selected or unselected
                                Icon(
                                    imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        },
                        label = {
                            Text(text = item.title)
                        }
                    )
                }
            }
        },
        //Fab
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(context, "post info to all members", Toast.LENGTH_SHORT).show()
            }, shape = RoundedCornerShape(50.dp)) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "fab_add")
            }
        }


    ) {
        when (items[selectedItemIndex].title) {
            Routes.HOME_SCREEN -> {
                //launch home screen
                Home(navigationController = navigationController)

            }

            Routes.PROFILE_SCREEN -> {
                //launch profile screen
                Profile(navigationController = navigationController)
            }

            Routes.MEMBERS_SCREEN -> {
                //launch members screen
                Members(navigationController = navigationController)
            }

            Routes.NOTIFICATION_SCREEN -> {
                //launch notification screen
                Notification(navigationController = navigationController)
            }

        }
    }
}


