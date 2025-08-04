package com.jesil.hiitworkoutapp.features.signup.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesil.hiitworkoutapp.R
import com.jesil.hiitworkoutapp.core.navigation.Screens
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.core.theme.ThemeAnnotation
import com.jesil.hiitworkoutapp.core.theme.darkGreen

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 24.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(
                text = "Join us and start your fitness journey!",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp)
                    .height(48.dp),
                onClick = {
                    navController.navigate(Screens.GoalScreen.route){
                        popUpTo(Screens.SignUpScreen.route){
                            inclusive = true
                        }
                    }
                },
                content = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            Icon(
                                modifier = Modifier.padding(end = 8.dp),
                                painter = painterResource(id = R.drawable.google_icon),
                                contentDescription = "Google Icon",
                                tint = Color.Black
                            )
                            Text(
                                text = "Sign in with Google",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    color = Color.Black,
                                    fontSize = 16.sp
                                )
                            )
                        }
                    )
                }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "By continuing, you agree to our Terms of Service and Privacy Policy",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = darkGreen,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    )
}

@ThemeAnnotation
@Composable
fun SignUpScreenPreview() {
    HIITWorkoutAppTheme {
        SignUpScreen(
            Modifier.fillMaxSize(),
            navController = rememberNavController()
        )
    }
}