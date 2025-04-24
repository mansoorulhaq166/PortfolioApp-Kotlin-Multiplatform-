package com.android.portfolio.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.android.portfolio.theme.PortfolioTheme
import com.android.portfolio.ui.components.ContactSection
import com.android.portfolio.ui.components.HeaderSection
import com.android.portfolio.ui.components.ProjectsSection
import com.android.portfolio.ui.components.SkillsSection
import com.android.portfolio.util.openUrl
import com.android.portfolio.viewmodel.PortfolioViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun App(context: Any) {
    PortfolioTheme {
        val viewModel = remember { PortfolioViewModel() }
        val portfolio = viewModel.portfolio
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val lazyListState = rememberLazyListState()

        val headerVisible = remember { MutableTransitionState(false).apply { targetState = true } }
        val skillsVisible = remember { MutableTransitionState(false).apply { targetState = true } }
        val projectsVisible = remember { MutableTransitionState(false).apply { targetState = true } }
        val contactVisible = remember { MutableTransitionState(false).apply { targetState = true } }

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = {},
                    backgroundColor = MaterialTheme.colors.surface,
                    elevation = 4.dp,
                    actions = {
                        TextButton(onClick = {
                            scope.launch { lazyListState.animateScrollToItem(0) }
                        }) {
                            Text("Home")
                        }
                        TextButton(onClick = {
                            scope.launch { lazyListState.animateScrollToItem(1) }
                        }) {
                            Text("Skills")
                        }
                        TextButton(onClick = {
                            scope.launch { lazyListState.animateScrollToItem(2) }
                        }) {
                            Text("Projects")
                        }
                        TextButton(onClick = {
                            scope.launch { lazyListState.animateScrollToItem(3) }
                        }) {
                            Text("Contact")
                        }
                    }
                )
            },
            backgroundColor = MaterialTheme.colors.background
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colors.background,
                                MaterialTheme.colors.background.copy(alpha = 0.9f)
                            )
                        )
                    )
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    state = lazyListState,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        AnimatedVisibility(
                            visibleState = headerVisible,
                            enter = fadeIn(spring(stiffness = Spring.StiffnessLow)) +
                                    slideInVertically(),
                            exit = fadeOut()
                        ) {
                            HeaderSection(context, portfolio)
                        }
                    }

                    item {
                        AnimatedVisibility(
                            visibleState = skillsVisible,
                            enter = fadeIn(spring(stiffness = Spring.StiffnessLow)) +
                                    slideInVertically(),
                            exit = fadeOut()
                        ) {
                            SkillsSection(portfolio)
                        }
                    }

                    item {
                        AnimatedVisibility(
                            visibleState = projectsVisible,
                            enter = fadeIn(spring(stiffness = Spring.StiffnessLow)) +
                                    slideInVertically(),
                            exit = fadeOut()
                        ) {
                            ProjectsSection(portfolio) { project ->
                                openUrl(context, project.link)
                            }
                        }
                    }

                    item {
                        AnimatedVisibility(
                            visibleState = contactVisible,
                            enter = fadeIn(spring(stiffness = Spring.StiffnessLow)) +
                                    slideInVertically(),
                            exit = fadeOut()
                        ) {
                            ContactSection(context, portfolio)
                        }
                    }
                }

                // Show FAB only if user is not at Contact section
                val showFab =
                    (lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) < 3

                AnimatedVisibility(
                    visible = showFab,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                    FloatingActionButton(
                        onClick = {
                            scope.launch {
                                lazyListState.animateScrollToItem(3)
                            }
                        },
                        backgroundColor = MaterialTheme.colors.primary,
                    ) {
                        Icon(Icons.Default.Email, contentDescription = "Contact Me")
                    }
                }
            }
        }
    }
}