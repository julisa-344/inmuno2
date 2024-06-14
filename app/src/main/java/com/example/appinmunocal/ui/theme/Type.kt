package com.example.appinmunocal.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.appinmunocal.R

val nunitoRegular = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Normal)
)

val quicksandMedium = FontFamily(
    Font(R.font.quicksand_medium, FontWeight.Medium)
)
val Typography = Typography(

    labelSmall = TextStyle(
        fontFamily = nunitoRegular,
        fontSize = 14.sp
    ) ,
    displaySmall = TextStyle(
        fontFamily = nunitoRegular,
        fontSize = 10.sp
    ) ,
    labelMedium = TextStyle(
        fontFamily = nunitoRegular,
        fontSize = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = nunitoRegular,
        fontSize = 30.sp
    ),
    titleLarge = TextStyle(
        fontFamily = quicksandMedium,
        fontSize = 30.sp
    ),
    titleMedium = TextStyle(
        fontFamily = quicksandMedium,
        fontSize = 24.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = quicksandMedium,
        fontSize = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = quicksandMedium,
        fontSize = 18.sp
    ),
    bodySmall = TextStyle(
        fontFamily = quicksandMedium,
        fontSize = 16.sp
    )
)
