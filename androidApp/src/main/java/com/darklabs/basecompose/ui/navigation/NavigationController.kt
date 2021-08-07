package com.darklabs.basecompose.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.darklabs.basecompose.ui.screen.AddEditNoteScreen
import com.darklabs.basecompose.ui.screen.NotesApp
import com.darklabs.basecompose.ui.screen.SettingsScreen
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationController(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberAnimatedNavController(),
    startDestination: Screens = Screens.NotesList
) {
    AnimatedNavHost(navController = navController, startDestination = startDestination.id) {

        composable(
            Screens.NotesList.id,
            enterTransition = { _, _ ->
                fadeIn(animationSpec = tween(200))
            }) {
            NotesApp(
                modifier = modifier.systemBarsPadding(),
                navController = navController
            )
        }

        composable(Screens.Settings.id,
            enterTransition = { _, _ ->
                fadeIn(animationSpec = tween(200))
            }) {
            SettingsScreen(navController = navController)
        }

        composable(Screens.CreateNote.id,
            enterTransition = { _, _ ->
                fadeIn(animationSpec = tween(200))
            }) {
            AddEditNoteScreen(
                navController = navController
            )
        }
    }

}

