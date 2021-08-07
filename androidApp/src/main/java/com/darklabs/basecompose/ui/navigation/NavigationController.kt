package com.darklabs.basecompose.ui.navigation

import android.os.Bundle
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.darklabs.basecompose.ui.screen.AddEditNoteScreen
import com.darklabs.basecompose.ui.screen.NotesApp
import com.darklabs.basecompose.ui.screen.SettingsScreen
import com.darklabs.domain.model.Note
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
                currentDestination = navController.currentDestination?.route,
                onCreateNoteClick = { note: Note? ->
                    note?.let {
                        navController.currentBackStackEntry?.arguments =
                            Bundle().apply { putParcelable("note", note) }
                    }
                    navController.navigate(Screens.CreateNote.id)
                },
                onDrawerItemClick = { route -> navController.navigate(route.id) }
            )
        }

        composable(Screens.Settings.id,
            enterTransition = { _, _ ->
                fadeIn(animationSpec = tween(200))
            }) {
            SettingsScreen()
        }

        composable(Screens.CreateNote.id,
            enterTransition = { _, _ ->
                fadeIn(animationSpec = tween(200))
            }) {
            AddEditNoteScreen(
                note = navController.previousBackStackEntry?.arguments?.getParcelable(
                    "note"
                ) ?: Note()
            )
        }
    }

}

