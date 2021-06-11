package com.darklabs.basecompose.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.darklabs.basecompose.ui.screen.AddEditNoteScreen
import com.darklabs.basecompose.ui.screen.NotesApp
import com.darklabs.basecompose.ui.screen.SettingsScreen
import com.google.accompanist.insets.systemBarsPadding

sealed class Screens(val id: String) {
    object NotesList : Screens("NotesList")
    object Reminders : Screens("Reminders")
    object CreateNote : Screens("CreateNote")
    object CreateLabel : Screens("CreateLabel")
    object Settings : Screens("Settings")
    object Help : Screens("Help")
    object Archive : Screens("Archive")
    object Deleted : Screens("Deleted")
}

@ExperimentalFoundationApi
@Composable
fun NavigationController(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Screens = Screens.NotesList
) {
    NavHost(navController = navController, startDestination = startDestination.id) {

        composable(Screens.NotesList.id) {
            NotesApp(
                modifier = modifier.systemBarsPadding(),
                navController = navController
            )
        }

        composable(Screens.Settings.id) {
            SettingsScreen(navController = navController)
        }

        composable(Screens.CreateNote.id) {
            AddEditNoteScreen(
                navController = navController
            )
        }
    }

}

