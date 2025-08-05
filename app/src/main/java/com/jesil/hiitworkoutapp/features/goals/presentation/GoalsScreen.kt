package com.jesil.hiitworkoutapp.features.goals.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.jesil.hiitworkoutapp.features.goals.data.goals
import com.jesil.hiitworkoutapp.features.goals.presentation.components.GoalsChip

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun GoalsScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var selectedGoals by remember { mutableStateOf(setOf<String>()) }

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
                                text = "Goals",
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
                            selectedGoals = emptySet()
                        },
                        content = {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Cancel"
                            )
                        }
                    )
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(vertical = 24.dp, horizontal = 16.dp),
                content = {
                    Text(
                        text = "What are your goals?",
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 28.sp,
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "We'll tailor your workouts to help you achieve your fitness aspirations.",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 16.sp,
                        )
                    )

                    FlowRow(
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 16.dp)
                            .verticalScroll(rememberScrollState()),
                        maxItemsInEachRow = 3,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        content = {
                            goals.forEachIndexed { index, goal ->
                                val isSelected = goal in selectedGoals
                                GoalsChip(
                                    isSelected = isSelected,
                                    label = goal,
                                    onSelected = {
                                        selectedGoals = if (isSelected) {
                                            selectedGoals - goal
                                        } else {
                                            selectedGoals + goal
                                        }
                                    }
                                )
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        enabled = selectedGoals.isNotEmpty(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .horizontalScroll(rememberScrollState()),
                        onClick = {
                            navController.navigate(Screens.CalorieScreen.route)
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
fun GoalScreenPreview() {
    HIITWorkoutAppTheme {
        GoalsScreen(
            modifier = Modifier.fillMaxSize(),
            navController = rememberNavController()
        )
    }
}