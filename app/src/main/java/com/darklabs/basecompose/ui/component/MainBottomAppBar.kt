package com.darklabs.basecompose.ui.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.darklabs.basecompose.R
import com.darklabs.basecompose.ui.theme.BaseComposeTheme

@Composable
fun MainBottomAppBar() {
    BottomAppBar(cutoutShape = CircleShape) {
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Edit, contentDescription = null)
        }
        IconButton(onClick = { }) {
            Icon(painterResource(id = R.drawable.ic_camera), contentDescription = null)
        }
        IconButton(onClick = { }) {
            Icon(painterResource(id = R.drawable.ic_mic), contentDescription = null)
        }
    }
}

@Preview
@Composable
fun PreviewBottomAppBar() {
    BaseComposeTheme {
        MainBottomAppBar()
    }
}