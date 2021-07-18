package com.darklabs.basecompose.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.darklabs.basecompose.R
import com.darklabs.basecompose.ui.theme.graySurface
import kotlinx.coroutines.launch

sealed class LayoutStyle(@DrawableRes val resId: Int) {
    object Grid : LayoutStyle(resId = R.drawable.ic_grid)
    object List : LayoutStyle(resId = R.drawable.ic_list)
}

@Composable
fun SearchBarComponent(
    offset: Int,
    layoutStyle: LayoutStyle = LayoutStyle.Grid,
    drawerState: DrawerState,
    showUserDialog: MutableState<Boolean>,
    textFieldValue: String,
    onLayoutChange: (LayoutStyle) -> Unit,
    onTextFieldValueChangeListener: (String) -> Unit
) {

    val searchLayoutHeightDp = 70.dp
    val background = if (isSystemInDarkTheme()) graySurface else Color.White

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .graphicsLayer(translationY = offset.toFloat())
            .height(searchLayoutHeightDp)
            .padding(8.dp)
            .shadow(8.dp, shape = RoundedCornerShape(8.dp), clip = false)
            .background(background, shape = RoundedCornerShape(8.dp))

    ) {

        val newLayout = when (layoutStyle) {
            is LayoutStyle.Grid -> LayoutStyle.List
            LayoutStyle.List -> LayoutStyle.Grid
        }

        val coroutineScope = rememberCoroutineScope()
        IconButton(
            onClick = {
                coroutineScope.launch {
                    drawerState.open()
                }
            },
        ) {
            Icon(imageVector = Icons.Outlined.Menu, contentDescription = null)
        }

        TextField(
            value = textFieldValue,
            placeholder = { Text("Search your notes") },
            onValueChange = { onTextFieldValueChangeListener(it) },
            modifier = Modifier.weight(1f),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = background,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.onSurface
            ),
            textStyle = typography.body2
        )

        IconButton(
            onClick = {
                onLayoutChange(newLayout)
            },
        ) {
            Icon(painterResource(id = newLayout.resId), contentDescription = null)
        }

        IconButton(
            onClick = {
                coroutineScope.launch {
                    showUserDialog.value = true
                }
            },
        ) {
            Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null)
        }
    }
}