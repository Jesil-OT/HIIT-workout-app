package com.jesil.hiitworkoutapp.features.goals.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.core.theme.ThemeAnnotation
import com.jesil.hiitworkoutapp.core.theme.darkLimeGreen
import com.jesil.hiitworkoutapp.core.theme.limeGreen

@Composable
fun GoalsChip(
    modifier: Modifier = Modifier,
    label: String,
    isSelected: Boolean = false,
    onSelected: (Boolean) -> Unit
) {
    val backgroundColor = if (isSystemInDarkTheme()) darkLimeGreen else limeGreen
    val isSelectedColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primary else backgroundColor,
        label = "isSelectedColor",
        animationSpec = tween(durationMillis = 500),
    )

    Surface(
        modifier = modifier,
        color = isSelectedColor,
        shape = RoundedCornerShape(16.dp),
        onClick = { onSelected(!isSelected) },
        interactionSource = remember { MutableInteractionSource() },
        content = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 14.sp
                ),
                modifier = Modifier.padding(vertical = 5.5.dp, horizontal = 16.dp)
            )
        }
    )
}

@ThemeAnnotation
@Composable
fun GoalsChipPreview() {
    HIITWorkoutAppTheme  {
        GoalsChip(
            label = "Endurance",
            onSelected = {}
        )
    }
}