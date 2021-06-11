package com.darklabs.basecompose.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darklabs.basecompose.R
import com.darklabs.basecompose.ui.navigation.Screens

@Composable
fun DrawerComponent(
    modifier: Modifier = Modifier,
    currentDestination: String?,
    onDestinationClick: (route: Screens) -> Unit
) {

    LazyColumn(modifier = modifier) {
        item {
            Text(
                text = "Google Keep",
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
            )
        }

        item {
            DrawerItem(
                icon = rememberVectorPainter(image = Icons.Outlined.ShoppingCart),
                title = "Notes",
                isSelected = currentDestination == Screens.NotesList.id,
            ) { onDestinationClick(Screens.NotesList) }
        }

        item {
            DrawerItem(
                icon = rememberVectorPainter(image = Icons.Outlined.Notifications),
                title = "Reminders",
                isSelected = currentDestination == Screens.Reminders.id,
            ) { onDestinationClick(Screens.Reminders) }
        }

        item { Spacer(modifier.padding(top = 8.dp)) }
        item { Divider(thickness = 0.3.dp) }
        item { Spacer(modifier.padding(top = 8.dp)) }

        item {
            DrawerItem(
                icon = rememberVectorPainter(image = Icons.Filled.Add),
                title = "Create new label",
                isSelected = currentDestination == Screens.CreateLabel.id,
            ) { onDestinationClick(Screens.CreateLabel) }
        }

        item { Spacer(modifier.padding(top = 8.dp)) }
        item { Divider(thickness = 0.3.dp) }
        item { Spacer(modifier.padding(top = 8.dp)) }

        item {
            DrawerItem(
                icon = painterResource(id = R.drawable.ic_archive),
                title = "Archive",
                isSelected = currentDestination == Screens.Archive.id,
            ) { onDestinationClick(Screens.Archive) }
        }

        item {
            DrawerItem(
                icon = rememberVectorPainter(image = Icons.Outlined.Delete),
                title = "Deleted",
                isSelected = currentDestination == Screens.Deleted.id,
            ) { onDestinationClick(Screens.Deleted) }
        }

        item { Spacer(modifier.padding(top = 8.dp)) }
        item { Divider(thickness = 0.3.dp) }
        item { Spacer(modifier.padding(top = 8.dp)) }


        item {
            DrawerItem(
                icon = rememberVectorPainter(image = Icons.Outlined.Settings),
                title = "Settings",
                isSelected = currentDestination == Screens.Settings.id,
            ) { onDestinationClick(Screens.Settings) }
        }

        item {
            DrawerItem(
                icon = painterResource(id = R.drawable.ic_help),
                title = "Help & feedback",
                isSelected = currentDestination == Screens.Help.id,
            ) { onDestinationClick(Screens.Help) }
        }
    }

}

@Composable
fun DrawerItem(
    icon: Painter,
    title: String,
    isSelected: Boolean = false,
    msgCount: String = "",
    onClick: () -> Unit
) {

    val background =
        if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.12f) else Color.Transparent
    val textColor = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
            .background(background, RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
            .clickable { onClick() }
    ) {
        Row {
            Icon(
                painter = icon,
                modifier = Modifier.padding(16.dp),
                contentDescription = null,
                tint = textColor
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp),
                text = title,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                color = textColor
            )

            if (msgCount.isNotEmpty()) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(16.dp),
                    color = textColor,
                    text = msgCount,
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Start
                )
            }

        }
    }
}

@Composable
fun DrawerCategory(title: String) {

    Text(
        text = title,
        letterSpacing = 0.7.sp,
        color = MaterialTheme.colors.onBackground,
        fontSize = 12.sp,
        modifier = Modifier.padding(16.dp)
    )

}
