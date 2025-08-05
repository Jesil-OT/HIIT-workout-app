package com.jesil.hiitworkoutapp.core.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.hiitworkoutapp.R
import com.jesil.hiitworkoutapp.core.navigation.Screens
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.core.theme.ThemeAnnotation
import com.jesil.hiitworkoutapp.core.theme.darkGreen

@Composable
fun BottomNavigationItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onSelected: () -> Unit = {},
    label: String,
    icon: Painter,
) {

    val isSelectedColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else darkGreen
    val selectedColor by animateColorAsState(
        targetValue = isSelectedColor,
        label = "selectedColorAnimation",
        animationSpec = tween(durationMillis = 500)
    )
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .clip(RoundedCornerShape(32.dp))
            .indication(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
            .clickable(
                onClick = { onSelected() },
            )

        ,
        contentAlignment = Alignment.Center,
        content = {
            Column(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Icon(
                    modifier = Modifier.size(width = 24.dp, height = 32.dp),
                    painter = icon,
                    contentDescription = label,
                    tint = selectedColor
                )

                Text(
                    text = label,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = selectedColor,
                        fontSize = 12.sp
                    )
                )
            }
        }
    )
}

@ThemeAnnotation
@Composable
fun BottomNavigationItemPreview() {
    HIITWorkoutAppTheme {
        BottomNavigationItem(
            modifier = Modifier,
            isSelected = false,
            label = Screens.HomeScreen.title ?: "",
            icon = painterResource(Screens.HomeScreen.icon ?: R.drawable.ic_launcher_background),
        )
    }
}