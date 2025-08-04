package com.jesil.hiitworkoutapp.features.calories.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.hiitworkoutapp.R
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.core.theme.ThemeAnnotation
import com.jesil.hiitworkoutapp.core.theme.lightLimeGreen
import com.jesil.hiitworkoutapp.core.theme.otherDarkLimeGreen
import com.jesil.hiitworkoutapp.core.theme.variantGreen

@Composable
fun CaloriesBox(
    modifier: Modifier = Modifier,
    caloriesLabel: String
) {
    val backgroundColor = if (isSystemInDarkTheme()) otherDarkLimeGreen  else Color.Transparent
    val strokeColor = if (isSystemInDarkTheme()) Color.Transparent else lightLimeGreen

    Surface(
        modifier = modifier.height(57.dp),
        border = BorderStroke(
            width = 1.dp,
            color = strokeColor
        ),
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        color = backgroundColor,
        interactionSource = remember { MutableInteractionSource() },
        content = {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "$caloriesLabel kcal",
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 20.sp
                        )
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.calories_icon),
                        contentDescription = "Calories",
                        tint = variantGreen
                    )
                }
            )
        }
    )
}

@ThemeAnnotation
@Composable
fun CaloriesBoxPreview() {
    HIITWorkoutAppTheme {
        CaloriesBox(
            modifier = Modifier.fillMaxWidth(),
            caloriesLabel = "500"
        )
    }
}