package com.jesil.hiitworkoutapp.features.gender.presentation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.hiitworkoutapp.core.theme.HIITWorkoutAppTheme
import com.jesil.hiitworkoutapp.core.theme.darkGreen
import com.jesil.hiitworkoutapp.core.theme.darkLimeGreen
import com.jesil.hiitworkoutapp.core.theme.white

@Composable
fun GenderItem(
    modifier: Modifier = Modifier,
    gender: String,
    image: Int,
    isSelected: Boolean = false,
    onSelected: (Boolean) -> Unit = {}
) {
    val border = if (isSelected) 3.dp else 0.dp
    val color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent
    val textColor = if (isSelected) darkGreen else white
    val selectedColor by animateColorAsState(
        targetValue = color,
        label = "color_selected",
        animationSpec = tween(1000)
    )
    val selectedTextColor by animateColorAsState(
        targetValue = textColor,
        label = "text_color_selected",
        animationSpec = tween(1000)
    )

    Box(
        modifier
            .border(
                width = border,
                color = selectedColor,
                shape = RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                onSelected(isSelected)
            }
    ) {
        val imageBitmap = ImageBitmap.imageResource(id = image)
        Image(
            contentScale = ContentScale.Crop,
            bitmap = imageBitmap,
            contentDescription = gender
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 15.dp)
                .align(Alignment.BottomStart),
            text = gender,
            style = MaterialTheme.typography.titleLarge.copy(
                color = selectedTextColor,
                fontSize = 20.sp
            ),
        )
    }
}

@Preview
@Composable
fun GenderItemPreview() {
    HIITWorkoutAppTheme {
        GenderItem(
            isSelected = true,
            modifier = Modifier.size(173.dp),
            gender = "Male",
            image = com.jesil.hiitworkoutapp.R.drawable.male_image
        )
    }
}