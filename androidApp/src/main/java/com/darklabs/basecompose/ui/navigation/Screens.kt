package com.darklabs.basecompose.ui.navigation

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