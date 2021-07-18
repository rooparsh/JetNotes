package com.darklabs.basecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.core.view.WindowCompat
import com.darklabs.basecompose.ui.navigation.NavigationController
import com.darklabs.basecompose.ui.navigation.Screens
import com.darklabs.basecompose.ui.theme.BaseComposeTheme
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            ProvideWindowInsets {
                BaseComposeTheme {
                    NavigationController(startDestination = Screens.NotesList)
                }
            }
        }
    }
}