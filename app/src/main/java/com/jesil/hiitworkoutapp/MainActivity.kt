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
import com.jesil.hiitworkoutapp.presentation.navigation.Screens
import com.jesil.hiitworkoutapp.presentation.on_boarding.OnBoardingScreen
import com.jesil.hiitworkoutapp.presentation.theme.HIITWorkoutAppTheme

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
                    ){
                        composable(Screens.OnboardingScreen.route){
                            OnBoardingScreen(navController = navController)
                        }
                        composable(Screens.SignInScreen.route){

                        }
                    }
                }
            }
        }
    }
}