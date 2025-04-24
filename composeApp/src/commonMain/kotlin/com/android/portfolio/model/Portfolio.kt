package com.android.portfolio.model

import org.jetbrains.compose.resources.DrawableResource

data class Portfolio(
    val name: String,
    val title: String,
    val summary: String,
    val skills: List<String>,
    val projects: List<Project>,
    val email: String,
    val profileImage: DrawableResource,
    val github: String,
    val linkedin: String
)

data class Project(
    val name: String,
    val techStack: List<String>,
    val link: String,
    val description: String
)