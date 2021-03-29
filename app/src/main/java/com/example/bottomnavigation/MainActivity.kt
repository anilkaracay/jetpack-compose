package com.example.bottomnavigation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme
import com.example.bottomnavigation.uitel.ProfileScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.bottomnavigation.model.Screen
import com.example.bottomnavigation.uitel.EditScreen
import com.example.bottomnavigation.uitel.FavoriteScreen
import com.example.bottomnavigation.uitel.NotificationScreen


class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      BottomNavigationTheme {
        val navController = rememberNavController()
        val titless = remember { mutableStateOf("Profile") }
        Surface(
          color = MaterialTheme.colors.background
        ) {
          Scaffold(topBar = {
            TopAppBar(
              title = { Text(text = titless.value) },
              actions = {
                IconButton(onClick = {
                  Toast.makeText(
                    this@MainActivity,
                    "Arama butonu",
                    Toast.LENGTH_SHORT
                  ).show()
                }) {
                  Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                  )

                }
              }
            )
          },
            bottomBar = {
              val items = listOf<Screen>(
                Screen.Profile,
                Screen.Edit,
                Screen.Favorite,
                Screen.Notification,
              )
              BottomNavigation(
                backgroundColor = Color.Transparent,
                elevation = 15.dp,
                modifier = Modifier
                  .background(color = Color.White)
                  .padding(
                    start = 22.dp,
                    end = 22.dp,
                    bottom = 15.dp,
                    top = 10.dp
                  )
              ) {
                val navBackStackEntry by navController
                  .currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry
                  ?.arguments?.getString(KEY_ROUTE)
                items.forEach {
                  BottomNavigationItem(
                    modifier=Modifier.background(Color.White,shape= RectangleShape),
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.Blue,
                    icon = {
                      Icon(
                        imageVector = it.icon,
                        contentDescription = "Profile"
                      )
                    },
                    selected = currentRoute == it.route,
                    onClick = {
                      navController.popBackStack(
                        navController.graph.startDestination,
                        false
                      )
                      if (currentRoute != it.route) {
                        navController.navigate(it.route)
                      }
                    })
                }

              }
            }
          ) {
            ScreenController(
              navController = navController,
              topTitleBar = titless
            )

          }
        }
      }
    }
  }
}
@Composable
fun ScreenController(
  navController: NavHostController,
  topTitleBar: MutableState<String>
) {
  NavHost(navController = navController, startDestination = "profile") {
    composable("profile") {
      ProfileScreen()
      topTitleBar.value = "Profile"
    }
    composable("edit") {
      EditScreen()
      topTitleBar.value = "Edit"

    }
    composable("favorite") {
      FavoriteScreen()
      topTitleBar.value = "Favorite"
    }
    composable("notification") {
      NotificationScreen()
      topTitleBar.value = "Notification"
    }
  }
}