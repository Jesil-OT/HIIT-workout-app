package com.jesil.hiitworkoutapp.features.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            Text(
                text = "Workout Screen",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    )
}

@Composable
fun HomeScreenPreview() {
    HIITWorkoutAppTheme {
        HomeScreen(
            modifier = Modifier.fillMaxSize(),
            navController = rememberNavController()
        )
    }
}