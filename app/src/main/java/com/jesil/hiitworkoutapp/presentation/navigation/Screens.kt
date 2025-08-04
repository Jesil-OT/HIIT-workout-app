package com.jesil.hiitworkoutapp.presentation.navigation

import com.jesil.hiitworkoutapp.R

sealed class Screens(val route: String, val title: String? = null, val icon: Int? = null) {
    object OnboardingScreen : Screens("onboarding_screen")
    object SignInScreen : Screens("sign_in_screen")
    object GoalScreen : Screens("goal_screen")
    object CalorieScreen : Screens("calorie_screen")
    object HomeScreen : Screens("home_screen", "Home", R.drawable.home_icon)
    object WorkoutScreen : Screens("workout_screen")
    object ProgressScreen : Screens("progress_screen", "Progress", R.drawable.progress_icon)
    object SettingsScreen : Screens("settings_screen", "Settings", R.drawable.settings_icon)
    object ProfileScreen : Screens("profile_screen")
}
