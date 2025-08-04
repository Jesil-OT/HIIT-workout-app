package com.jesil.hiitworkoutapp.core.on_boarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesil.hiitworkoutapp.core.navigation.Screens
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.core.theme.ThemeAnnotation

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 24.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "7-Minute Blitz",
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.onPrimary
            ),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Quick, effective workouts for busy lives.",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onPrimary
            ),
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier.fillMaxWidth().height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.Black
            ),
            onClick = {
                navController.navigate(Screens.SignUpScreen.route){
                    popUpTo(Screens.OnboardingScreen.route){
                        inclusive = true
                    }
                }
            }
        ) {
            Text(
                text = "Get Started",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.Black,
                    fontSize = 16.sp
                ),
            )
        }
    }
}

@ThemeAnnotation
@Composable
private fun OnBoardingScreenPreview() {
    HIITWorkoutAppTheme {
        OnBoardingScreen(
            modifier = Modifier.fillMaxSize(),
            navController = rememberNavController()
        )
    }
}