package com.jesil.hiitworkoutapp.features.calories.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesil.hiitworkoutapp.core.navigation.Screens
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.core.theme.ThemeAnnotation
import com.jesil.hiitworkoutapp.core.theme.black
import com.jesil.hiitworkoutapp.features.calories.presentation.components.CaloriesBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaloriesScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                        content = {
                            Text(
                                modifier = Modifier.offset(x = (-24).dp),
                                text = "Set Your Goal",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    )

                },
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    scrolledContainerColor = MaterialTheme.colorScheme.background,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        },
                        content = {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Cancel"
                            )
                        }
                    )
                }
            )
        },
        content = { innerPadding ->
            var calories by remember { mutableFloatStateOf(500f) }
            Column(
                modifier = Modifier.padding(innerPadding)
                    .padding(vertical = 24.dp, horizontal = 16.dp),
                content = {
                    Text(
                        text = "How many calories do you want to burn each day?",
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                    CaloriesBox(
                        modifier = Modifier.padding(top = 24.dp),
                        caloriesLabel = calories.toInt().toString()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "This helps us tailor workouts to your fitness goals.",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            Text(
                                text = "Calories",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    fontSize = 16.sp
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = calories.toInt().toString(),
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    fontSize = 14.sp
                                )
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Slider(
                        modifier = Modifier.fillMaxWidth(),
                        value = calories,
                        onValueChange = {
                            calories = it
                        },
                        valueRange = 0f..5000f,
                        steps = 20
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        onClick = {
                            navController.navigate(Screens.HomeScreen)
                        },
                        content = {
                            Text(
                                text = "Next",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    color = black,
                                    fontSize = 16.sp
                                )
                            )
                        },
                        enabled = calories > 0,
                        colors = ButtonDefaults.buttonColors(
                            disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                            disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                        )
                    )
                }
            )
        }
    )
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