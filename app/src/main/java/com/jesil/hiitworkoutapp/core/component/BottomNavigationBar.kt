package com.jesil.hiitworkoutapp.core.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jesil.hiitworkoutapp.R
import com.jesil.hiitworkoutapp.core.navigation.Screens
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.core.theme.ThemeAnnotation
import kotlinx.serialization.Serializable

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    isCurrentlySelected: (String) -> Boolean
) {
    val items = listOf(
        BottomNavItem(
            name = Screens.HomeScreen.title ?: "",
            route = Screens.HomeScreen.route,
            icon = Screens.HomeScreen.icon ?: R.drawable.ic_launcher_background
        ),

        BottomNavItem(
            name = Screens.ProgressScreen.title ?: "",
            route = Screens.ProgressScreen.route,
            icon = Screens.ProgressScreen.icon ?: R.drawable.ic_launcher_background
        ),

        BottomNavItem(
            name = Screens.SettingsScreen.title ?: "",
            route = Screens.SettingsScreen.route,
            icon = Screens.SettingsScreen.icon ?: R.drawable.ic_launcher_background
        )
    )
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Spacer(modifier = Modifier.weight(.1f))
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                modifier = Modifier.weight(1f),
                isSelected = isCurrentlySelected(item.route),
                onSelected = {
                    navController.navigate(item.route)
                },
                label = item.name,
                icon = painterResource(item.icon),
            )
        }
        Spacer(modifier = Modifier.weight(.1f))
    }
}

@Serializable
data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: Int,
    val badgeCount: Int? = null
)


@ThemeAnnotation
@Composable
fun BottomNavigationBarPreview(modifier: Modifier = Modifier) {
    HIITWorkoutAppTheme {
        BottomNavigationBar(
            modifier = modifier,
            isCurrentlySelected = { false },
            navController = rememberNavController()
        )
    }
}