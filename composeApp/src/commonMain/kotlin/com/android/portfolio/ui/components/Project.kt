package com.android.portfolio.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.portfolio.model.Portfolio
import com.android.portfolio.model.Project

@Composable
fun ProjectsSection(portfolio: Portfolio, onProjectClick: (Project) -> Unit) {
    Surface(
        color = Color(0xFF121212),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "Projects",
                    tint = Color(0xFFBB86FC),
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "PROJECTS",
                    style = MaterialTheme.typography.h5,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                portfolio.projects.forEach { project ->
                    ProjectCard(
                        project = project,
                        onClick = { onProjectClick(project) }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectCard(project: Project, onClick: () -> Unit) {
    val isPressed = remember { mutableStateOf(false) }
    val cardColor = if (isPressed.value) Color(0xFF1E1E1E) else Color(0xFF1F1F1F)
    val borderColor = animateColorAsState(
        targetValue = if (isPressed.value) Color(0xFFBB86FC) else Color(0xFF2D2D2D)
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed.value = true
                        tryAwaitRelease()
                        isPressed.value = false
                        onClick()
                    }
                )
            },
        elevation = if (isPressed.value) 12.dp else 4.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = cardColor,
        border = BorderStroke(1.dp, borderColor.value)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .animateContentSize()
        ) {
            // Project Header with Glow Effect
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFBB86FC).copy(alpha = 0.2f),
                                Color(0xFF03DAC5).copy(alpha = 0.1f)
                            )
                        )
                    )
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = project.name,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Project Description
            Text(
                text = project.description,
                style = MaterialTheme.typography.body1,
                color = Color(0xFFB0B0B0),
                lineHeight = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Tech Stack Chips
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                project.techStack.forEach { tech ->
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF2D2D2D),
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Text(
                            color = Color(0xFF03DAC5),
                            style = MaterialTheme.typography.caption,
                            text = tech,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }
            }

            // View Project Button with Hover Effect
            if (project.link.isNotBlank()) {
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color.Transparent,
                    border = BorderStroke(1.dp, Color(0xFFBB86FC)),
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable(onClick = onClick)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "EXPLORE",
                            style = MaterialTheme.typography.button,
                            color = Color(0xFFBB86FC),
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowForward,
                            contentDescription = "Open Project",
                            tint = Color(0xFFBB86FC),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}