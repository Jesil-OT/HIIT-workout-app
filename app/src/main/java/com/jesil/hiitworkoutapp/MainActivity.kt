package com.jesil.hiitworkoutapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jesil.hiitworkoutapp.core.component.BottomNavigationBar
import com.jesil.hiitworkoutapp.features.signup.presentation.SignUpScreen
import com.jesil.hiitworkoutapp.core.navigation.Screens
import com.jesil.hiitworkoutapp.core.on_boarding.OnBoardingScreen
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.features.calories.presentation.CaloriesScreen
import com.jesil.hiitworkoutapp.features.gender.presentation.GenderScreen
import com.jesil.hiitworkoutapp.features.goals.presentation.GoalsScreen
import com.jesil.hiitworkoutapp.features.home.presentation.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HIITWorkoutAppTheme {
                val navController = rememberNavController()
                val navBackStackEntry = navController.currentBackStackEntryAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        val bottomBarVisibility = (navBackStackEntry.value?.destination?.route == Screens.HomeScreen.route
                                || navBackStackEntry.value?.destination?.route == Screens.ProgressScreen.route
                                || navBackStackEntry.value?.destination?.route == Screens.SettingsScreen.route)
                        AnimatedContent(
                            targetState = bottomBarVisibility,
                            label = "bottomBarVisibility",
                            content = { isVisible ->
                                if (isVisible) {
                                    BottomNavigationBar(
                                        modifier = Modifier.fillMaxWidth(),
                                        isCurrentlySelected = { route -> navBackStackEntry.value?.destination?.route == route },
                                        navController = navController
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screens.OnboardingScreen.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screens.OnboardingScreen.route) {
                            OnBoardingScreen(navController = navController)
                        }
                        composable(Screens.SignUpScreen.route) {
                            SignUpScreen(navController = navController)
                        }
                        composable(Screens.GoalScreen.route) {
                            GoalsScreen(navController = navController)
                        }
                        composable(Screens.GenderScreen.route) {
                            GenderScreen(navController = navController)
                        }
                        composable(Screens.CalorieScreen.route) {
                            CaloriesScreen(navController = navController)
                        }
                        composable(Screens.HomeScreen.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(Screens.ProgressScreen.route) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center,
                                content = {
                                    Text(
                                        text = "Progress Screen",
                                        style = MaterialTheme.typography.titleLarge.copy(
                                            color = MaterialTheme.colorScheme.onPrimary
                                        )
                                    )
                                }
                            )
                        }

                        composable(Screens.SettingsScreen.route) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center,
                                content = {
                                    Text(
                                        text = "Settings Screen",
                                        style = MaterialTheme.typography.titleLarge.copy(
                                            color = MaterialTheme.colorScheme.onPrimary
                                        )
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}