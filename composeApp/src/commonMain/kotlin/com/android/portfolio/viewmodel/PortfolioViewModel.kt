package com.android.portfolio.viewmodel

import androiddevportfolio.composeapp.generated.resources.Res
import androiddevportfolio.composeapp.generated.resources.profile
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.android.portfolio.model.Portfolio
import com.android.portfolio.model.Project

class PortfolioViewModel {
    var portfolio by mutableStateOf(createPortfolio())
        private set

    private fun createPortfolio(): Portfolio {
        return Portfolio(
            name = "Mansoor ul Haq",
            title = "Android & Kotlin Multiplatform Developer",
            summary = "Android Developer passionate about crafting seamless UI/UX, cross-platform experiences, and building powerful Android apps using Jetpack Compose, KMP, and more.",
            skills = listOf(
                "Kotlin",
                "Android Development",
                "Jetpack Compose",
                "Kotlin Multiplatform (KMP)",
                "TensorFlow Lite (on-device ML)",
                "Clean Architecture (MVVM, MVI)",
                "Hilt (Dependency Injection)",
                "CI/CD (GitHub Actions)",
                "Room / DataStore / Firebase",
                "Jetpack Libraries (Navigation, Lifecycle, WorkManager)",
                "UI/UX Design Principles",
                "REST API Integration",
                "Coroutines & Flow",
                "Testing (Unit, UI - Espresso, JUnit)"
            ),
            projects = listOf(
                Project(
                    name = "Guess Master",
                    link = "https://github.com/mansoorulhaq166/Guess-The-Number",
                    description = "A Jetpack Compose-powered Android game where players guess a hidden number based on hints.",
                    techStack = listOf("Kotlin", "Jetpack Compose", "MVVM", "Hilt", "Material 3", "StateFlow")
                ),
                Project(
                    name = "Word Connect Puzzle",
                    link = "https://github.com/mansoorulhaq166/Word-Connect-Puzzle",
                    description = "A word formation puzzle game with hundreds of levels.",
                    techStack = listOf("Kotlin", "Jetpack Compose", "Game Development", "In-App Purchases", "Firebase Analytics")
                ),
                Project(
                    name = "PortfolioApp(Kotlin Multiplatform)",
                    link = "https://github.com/mansoorulhaq166/PortfolioApp-Kotlin-Multiplatform-",
                    description = "A Compose Multiplatform based portfolio app.",
                    techStack = listOf("KMP", "Jetpack Compose", "Android", "Desktop", "Web")
                ),
                Project(
                    name = "Campus Recruitment System",
                    link = "https://github.com/mansoorulhaq166/CamousRecruitmentSystem",
                    description = "A feature-rich Android app developed with Kotlin & XML to streamline campus recruitment processes.",
                    techStack = listOf("Kotlin", "XML", "MVVM", "Firebase", "AdMob")
                ),
                Project(
                    name = "QuickSnap",
                    link = "https://github.com/mansoorulhaq166/QuickSnap",
                    description = "A clean and minimal Android camera app built with Kotlin, featuring photo capture and basic editing options.",
                    techStack = listOf("Kotlin", "CameraX", "Jetpack Compose", "Android")
                ),
                Project(
                    name = "Simple BMI Calculator",
                    link = "https://github.com/mansoorulhaq166/bmi-calculaor",
                    description = "A straightforward Android app to calculate Body Mass Index (BMI) based on user input.",
                    techStack = listOf("Kotlin", "XML", "MVVM", "Android")
                )
            ),
            email = "mansoorulhaq166@gmail.com",
            profileImage = Res.drawable.profile,
            github = "https://github.com/mansoorulhaq166",
            linkedin = "https://linkedin.com/in/mansoor-ul-haq13"
        )
    }
}