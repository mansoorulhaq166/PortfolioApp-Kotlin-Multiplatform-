package com.android.portfolio.ui.components

import androiddevportfolio.composeapp.generated.resources.Res
import androiddevportfolio.composeapp.generated.resources.github_logo
import androiddevportfolio.composeapp.generated.resources.linkedIn_icon
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.portfolio.model.Portfolio
import com.android.portfolio.util.openUrl
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContactSection(context: Any, portfolio: Portfolio) {
    SectionCardFooter (
        title = "Get in Touch",
        icon = Icons.Default.Email
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            ContactItem(
                label = portfolio.email,
                url = "mailto:${portfolio.email}",
                icon = Icons.Default.Email,
                color = MaterialTheme.colors.primary,
                context = context
            )
            ContactItem(
                label = "GitHub",
                url = portfolio.github,
                icon = Res.drawable.github_logo,
                color = Color.Black,
                context = context
            )
            ContactItem(
                label = "LinkedIn",
                url = portfolio.linkedin,
                icon = Res.drawable.linkedIn_icon,
                color = Color(0xFF0A66C2),
                context = context
            )
        }
    }
}

@Composable
fun ContactItem(
    label: String,
    url: String,
    icon: Any,
    color: Color,
    context: Any
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        elevation = 2.dp,
        color = MaterialTheme.colors.surface,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { openUrl(context, url) }
            .animateContentSize()
            .padding(horizontal = 2.dp, vertical = 2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = color.copy(alpha = 0.1f),
                modifier = Modifier.size(40.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    when (icon) {
                        is ImageVector -> {
                            Icon(
                                imageVector = icon,
                                contentDescription = label,
                                tint = color,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                        is DrawableResource -> {
                            Image(
                                painter = painterResource(icon),
                                contentDescription = label,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                        else -> {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = label,
                                tint = color,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.body1.copy(fontSize = 16.sp),
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Composable
fun SectionCardFooter(
    title: String,
    icon: ImageVector,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = 6.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.padding(vertical = 20.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(26.dp)
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6.copy(fontSize = 20.sp),
                    color = MaterialTheme.colors.onBackground
                )
            }
            Spacer(Modifier.height(20.dp))
            content()
        }
    }
}