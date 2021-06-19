package com.darklabs.basecompose.ui.screen

import android.os.Bundle
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.darklabs.basecompose.MainViewModel
import com.darklabs.basecompose.ui.component.*
import com.darklabs.basecompose.ui.navigation.Screens
import com.darklabs.basecompose.ui.theme.BaseComposeTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun NotesApp(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()
    val searchOffsetY = remember { mutableStateOf(0) }
    val showUserDialog = remember { mutableStateOf(false) }
    val (searchBarText, setSearchBarText) = remember { mutableStateOf("") }
    val (layoutStyle, setLayoutStyle) = remember { mutableStateOf<LayoutStyle>(LayoutStyle.Grid) }
    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            SearchBarComponent(
                searchOffsetY.value,
                layoutStyle,
                scaffoldState.drawerState,
                showUserDialog,
                searchBarText,
                setLayoutStyle,
                setSearchBarText
            )
        },
        bottomBar = {
            MainBottomAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screens.CreateNote.id) }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }
        },
        drawerContent = {
            DrawerComponent(currentDestination = navController.currentDestination?.route) { route ->
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                    navController.navigate(route.id)
                }
            }
        },
        drawerBackgroundColor = MaterialTheme.colors.background,
        drawerContentColor = MaterialTheme.colors.onBackground,
        isFloatingActionButtonDocked = true
    ) {

        viewModel.getNotes()
        val list = viewModel.notesList

        var isRefreshing = false
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
            onRefresh = {
                viewModel.getNotes()
                isRefreshing = true
            },
            indicator = { state, refreshTrigger ->
                SwipeRefreshIndicator(
                    state = state,
                    refreshTriggerDistance = refreshTrigger,
                    scale = true
                )
            }) {
            when (layoutStyle) {
                LayoutStyle.Grid -> {
                    Column(
                        modifier = Modifier
                            .verticalScroll(state = rememberScrollState())
                            .animateContentSize()
                            .padding(8.dp)
                    ) {
                        StaggeredVerticalGrid(maxColumnWidth = 220.dp) {
                            list.forEach { note ->
                                NotesItemGrid(note = note) {
                                    navController.currentBackStackEntry?.arguments =
                                        Bundle().apply { putParcelable("note", note) }
                                    navController.navigate(Screens.CreateNote.id)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(it.calculateBottomPadding()))
                    }
                }
                LayoutStyle.List -> {
                    LazyColumn(
                        modifier = Modifier
                            .animateContentSize(),
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        items(list) { note ->
                            NotesItemList(note = note) {
                                navController.currentBackStackEntry?.arguments =
                                    Bundle().apply { putParcelable("note", note) }
                                navController.navigate(Screens.CreateNote.id)
                            }
                        }

                        item {
                            Spacer(modifier = Modifier.height(it.calculateBottomPadding()))
                        }
                    }
                }
            }
        }

    }
}


@ExperimentalFoundationApi
@Preview(showSystemUi = true)
@Composable
fun PreviewNotesApp() {
    BaseComposeTheme {
        NotesApp(navController = rememberNavController())
    }
}