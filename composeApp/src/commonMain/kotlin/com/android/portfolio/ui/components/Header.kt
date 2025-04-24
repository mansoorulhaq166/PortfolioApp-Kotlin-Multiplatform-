package com.android.portfolio.ui.components

import androiddevportfolio.composeapp.generated.resources.Res
import androiddevportfolio.composeapp.generated.resources.github_logo
import androiddevportfolio.composeapp.generated.resources.linkedIn_icon
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.portfolio.model.Portfolio
import com.android.portfolio.util.openUrl
import org.jetbrains.compose.resources.painterResource

@Composable
fun HeaderSection(context: Any, portfolio: Portfolio) {
    val infiniteTransition = rememberInfiniteTransition()
    val glow = infiniteTransition.animateFloat(0.9f, 1.1f, infiniteRepeatable(tween(2000, easing = FastOutSlowInEasing), RepeatMode.Reverse))
    val rotate = infiniteTransition.animateFloat(-2f, 2f, infiniteRepeatable(tween(3000, easing = FastOutSlowInEasing), RepeatMode.Reverse))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(brush = Brush.verticalGradient(listOf(MaterialTheme.colors.background, MaterialTheme.colors.background.copy(0.8f))))
            .padding(vertical = 24.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(180.dp).padding(8.dp)) {
            Box(
                modifier = Modifier.size(170.dp).graphicsLayer {
                    scaleX = glow.value
                    scaleY = glow.value
                }.background(
                    brush = Brush.radialGradient(listOf(MaterialTheme.colors.primary.copy(0.3f), Color.Transparent)),
                    shape = CircleShape
                )
            )
            Image(
                painter = painterResource(portfolio.profileImage),
                contentDescription = "Profile picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(150.dp).clip(CircleShape).border(
                    3.dp, Brush.linearGradient(listOf(MaterialTheme.colors.primary, MaterialTheme.colors.secondary)), CircleShape
                ).shadow(8.dp, CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = portfolio.name,
            style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier.padding(vertical = 8.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colors.primary.copy(0.1f))
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Text(
                text = portfolio.title,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Card(
            elevation = 2.dp,
            shape = RoundedCornerShape(12.dp),
            backgroundColor = MaterialTheme.colors.surface.copy(0.8f),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
        ) {
            Text(text = portfolio.summary, style = MaterialTheme.typography.body1, textAlign = TextAlign.Center, modifier = Modifier.padding(16.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 16.dp)) {
            Icon(Icons.Rounded.LocationOn, contentDescription = "Location", tint = MaterialTheme.colors.primary, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Islamabad, Pakistan",
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onBackground.copy(0.7f)
            )
        }

        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
            SocialButton(
                icon = Res.drawable.github_logo,
                contentDescription = "GitHub",
                backgroundColor = MaterialTheme.colors.primary,
                tint = MaterialTheme.colors.onPrimary,
                rotationValue = rotate.value,
                onClick = { openUrl(context, "https://github.com/mansoorulhaq166") }
            )

            Spacer(modifier = Modifier.width(16.dp))
            SocialButton(
                icon = Res.drawable.linkedIn_icon,
                contentDescription = "LinkedIn",
                backgroundColor = MaterialTheme.colors.primary,
                tint = MaterialTheme.colors.onPrimary,
                rotationValue = rotate.value,
                onClick = { openUrl(context, "https://www.linkedin.com/in/mansoor-ul-haq13") }
            )
        }
    }
}

@Composable
fun SocialButton(
    icon: Any,
    contentDescription: String,
    backgroundColor: Color,
    tint: Color,
    rotationValue: Float = 0f,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .graphicsLayer { rotationZ = rotationValue }
            .clip(CircleShape)
            .background(backgroundColor)
    ) {
        when (icon) {
            is ImageVector -> Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = tint,
                modifier = Modifier.size(48.dp)
            )
            is org.jetbrains.compose.resources.DrawableResource -> Image(
                painter = painterResource(icon),
                contentDescription = contentDescription,
                modifier = Modifier.size(48.dp)
            )
            else -> throw IllegalArgumentException("Unsupported icon type")
        }
    }
}