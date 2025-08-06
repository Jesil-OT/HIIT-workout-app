package com.jesil.hiitworkoutapp.features.gender.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesil.hiitworkoutapp.core.navigation.Screens
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.core.theme.ThemeAnnotation
import com.jesil.hiitworkoutapp.core.theme.black
import com.jesil.hiitworkoutapp.features.calories.data.genders

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderScreen(
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
                                text = "About you",
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
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                content = {
                    Text(
                        text = "What's your gender?",
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "We need to know your gender so we can customize your 7-min workout. This helps us tailor workouts to your fitness goals.",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 16.sp
                        )
                    )
                    var selectedGender = remember { mutableIntStateOf(-1) }
                    Row(
                        modifier = Modifier.padding(top = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        content = {
                            genders.forEachIndexed { index, gender ->
                                GenderItem(
                                    modifier = Modifier.size(175.dp),
                                    gender = gender.gender,
                                    image = gender.image,
                                    isSelected = selectedGender.intValue == index,
                                    onSelected = {
                                        selectedGender.intValue = index
                                    }
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "I prefer not to say",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.Underline
                        ),
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        enabled = selectedGender.value != -1,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        onClick = {
                            navController.navigate(Screens.CalorieScreen.route)
                        },
                        content = {
                            Text(
                                text = "Continue",
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
fun GenderScreenPreview() {
    HIITWorkoutAppTheme {
        GenderScreen(
            modifier = Modifier.fillMaxSize(),
            navController = rememberNavController()
        )
    }
}