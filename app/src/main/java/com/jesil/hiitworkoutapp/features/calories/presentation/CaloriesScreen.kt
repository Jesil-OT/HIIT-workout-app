package com.jesil.hiitworkoutapp.features.calories.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.core.theme.ThemeAnnotation

@Composable
fun CaloriesScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

}

@ThemeAnnotation
@Composable
fun CaloriesScreenPreview() {
    HIITWorkoutAppTheme {
        CaloriesScreen(
            modifier = Modifier.fillMaxSize(),
            navController = rememberNavController()
        )
    }
}