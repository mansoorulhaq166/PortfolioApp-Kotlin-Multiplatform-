package com.android.portfolio.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.android.portfolio.model.Portfolio
import com.android.portfolio.util.openUrl

@Composable
fun ContactSection(portfolio: Portfolio) {
    SectionCard(
        title = "Contact",
        icon = Icons.Default.Email
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ContactItem(
                label = portfolio.email,
                url = "mailto:${portfolio.email}",
                icon = Icons.Default.Email
            )
            ContactItem(
                label = "GitHub",
                url = "https://github.com/mansoorulhaq166",
                icon = Icons.Default.Info
            )
            ContactItem(
                label = "LinkedIn",
                url = "https://www.linkedin.com/in/mansoor-ul-haq13",
                icon = Icons.Default.Build
            )
        }
    }
}

@Composable
fun ContactItem(
    label: String,
    url: String,
    icon: ImageVector
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.width(12.dp))
        TextButton(onClick = { openUrl(url) }) {
            Text(
                text = label,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.primary
            )
        }
    }
}

//@Composable
//fun SectionCard(
//    title: String,
//    icon: ImageVector,
//    content: @Composable ColumnScope.() -> Unit
//) {
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(16.dp),
//        elevation = 4.dp,
//        backgroundColor = MaterialTheme.colors.surface
//    ) {
//        Column(modifier = Modifier.padding(vertical = 16.dp)) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(horizontal = 16.dp)
//            ) {
//                Icon(
//                    imageVector = icon,
//                    contentDescription = null,
//                    tint = MaterialTheme.colors.primary,
//                    modifier = Modifier.size(24.dp)
//                )
//                Spacer(Modifier.width(12.dp))
//                Text(
//                    text = title,
//                    style = MaterialTheme.typography.h5,
//                    color = MaterialTheme.colors.onSurface
//                )
//            }
//            Spacer(Modifier.height(16.dp))
//            content()
//        }
//    }
//}