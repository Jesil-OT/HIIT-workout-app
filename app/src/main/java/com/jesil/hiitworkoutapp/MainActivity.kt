package com.jesil.hiitworkoutapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jesil.hiitworkoutapp.features.signup.presentation.SignUpScreen
import com.jesil.hiitworkoutapp.core.navigation.Screens
import com.jesil.hiitworkoutapp.core.on_boarding.OnBoardingScreen
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.features.calories.presentation.CaloriesScreen
import com.jesil.hiitworkoutapp.features.goals.presentation.GoalsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HIITWorkoutAppTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
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
                        composable(Screens.CalorieScreen.route) {
                            CaloriesScreen(navController = navController)
                        }


                    }
                }
            }
        }
    }
}