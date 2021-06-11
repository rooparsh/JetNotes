package com.darklabs.basecompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.darklabs.basecompose.ui.theme.graySurface
import com.darklabs.domain.model.Note
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun AddEditNoteScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    note: Note = navController.previousBackStackEntry?.arguments?.getParcelable("note") ?: Note()
) {

    val (data, setData) = remember { mutableStateOf(note) }

    val background = if (isSystemInDarkTheme()) graySurface else Color.White

    Scaffold {
        Column {
            data.imageUrl?.let { imageUrl ->
                Image(
                    painter = rememberCoilPainter(
                        request = imageUrl,
                        fadeIn = true
                    ),
                    contentDescription = null
                )

                Divider()
            }

            TextField(
                value = data.title.orEmpty(),
                placeholder = { Text("Title") },
                onValueChange = { setData(note.apply { title = it }) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = background,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colors.onSurface
                ),
                textStyle = MaterialTheme.typography.subtitle1
            )

            TextField(
                value = data.content.orEmpty(),
                placeholder = { Text("Add your note") },
                onValueChange = { setData(note.apply { content = it }) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = background,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colors.onSurface
                ),
                textStyle = MaterialTheme.typography.body1
            )


        }
    }
}