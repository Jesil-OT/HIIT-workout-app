package com.jesil.hiitworkoutapp.core.navigation

import com.jesil.hiitworkoutapp.R
import kotlinx.serialization.Serializable

@Serializable
sealed class Screens(
    val route: String,
    val title: String? = null,
    val icon: Int? = null
) {
    @Serializable object OnboardingScreen : Screens("onboarding_screen")
    @Serializable object SignUpScreen : Screens("sign_up_screen")
    @Serializable object GoalScreen : Screens("goal_screen")
    @Serializable object CalorieScreen : Screens("calorie_screen")
    @Serializable object HomeScreen : Screens("home_screen", "Home", R.drawable.home_icon)
    @Serializable object WorkoutScreen : Screens("workout_screen")
    @Serializable object ProgressScreen : Screens("progress_screen", "Progress", R.drawable.progress_icon)
    @Serializable object SettingsScreen : Screens("settings_screen", "Settings", R.drawable.settings_icon)
    @Serializable object ProfileScreen : Screens("profile_screen")
}
