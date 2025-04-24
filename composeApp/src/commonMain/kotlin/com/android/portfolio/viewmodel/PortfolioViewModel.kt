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
                    description = "A number guessing game with hints and difficulty levels.",
                    techStack = listOf("Kotlin", "Jetpack Compose", "MVVM", "Android")
                ),
                Project(
                    name = "Word Connect Puzzle",
                    link = "https://github.com/mansoorulhaq166/Word-Connect-Puzzle",
                    description = "A word formation puzzle game with hundreds of levels.",
                    techStack = listOf("Kotlin", "Jetpack Compose", "Game Dev", "Custom View")
                ),
                Project(
                    name = "Islamic Utility App",
                    link = "No Link",
                    description = "Prayer times, Qibla, Tasbeeh, and Quran features.",
                    techStack = listOf("Kotlin", "Location", "Permissions", "Sensor API", "UI Design")
                ),
                Project(
                    name = "AndroidDevPortfolio",
                    link = "No Link",
                    description = "A Compose Multiplatform based portfolio app.",
                    techStack = listOf("KMP", "Jetpack Compose", "Android", "Desktop", "Web")
                )
            ),
            email = "mansoorulhaq166@gmail.com",
            profileImage = Res.drawable.profile,
            github = "https://github.com/mansoorulhaq",
            linkedin = "https://linkedin.com/in/mansoorulhaq"
        )
    }
}