package com.jesil.hiitworkoutapp.features.calories.data

data class Gender(
    val gender: String,
    val image: Int
)

val genders = listOf(
    Gender("Male", com.jesil.hiitworkoutapp.R.drawable.male_image),
    Gender("Female", com.jesil.hiitworkoutapp.R.drawable.female_image)
)
