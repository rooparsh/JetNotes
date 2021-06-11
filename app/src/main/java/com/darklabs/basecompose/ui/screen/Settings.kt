package com.darklabs.basecompose.ui.screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.darklabs.basecompose.BaseApplication

@Composable
fun SettingsScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    //val notesApplication = LocalContext.current.applicationContext as NotesApplication
    Scaffold(topBar = {
        TopAppBar() {

        }
    }) {
        Column {
            Text(
                text = "Display Options",
                fontSize = 10.sp,
                color = MaterialTheme.colors.secondary
            )
            Row {
                Text(
                    text = "Theme",
                    style = MaterialTheme.typography.button
                )
                Switch(checked = isSystemInDarkTheme(), onCheckedChange = { isChecked ->
                    //notesApplication.toggleTheme()
                })
            }
        }
    }
}