package com.darklabs.basecompose.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.darklabs.domain.model.Note

@OptIn(ExperimentalCoilApi::class)
@Composable
fun NotesItemGrid(modifier: Modifier = Modifier, note: Note, onClick: () -> Unit) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.background)
            .border(
                1.dp, color = if (isSystemInDarkTheme()) Color.White else Color.Gray,
                RoundedCornerShape(4.dp)
            )
            .animateContentSize()
            .clickable { onClick() }
    ) {
        Column {

            note.imageUrl?.let { imageUrl ->
                Image(
                    painter = rememberImagePainter(
                        data = imageUrl,
                        builder = { crossfade(true) }
                    ),
                    contentDescription = null
                )

                Divider()
            }


            note.title?.let { content ->
                Text(
                    style = MaterialTheme.typography.h3,
                    fontSize = 14.sp,
                    text = content,
                    modifier = Modifier.padding(5.dp),
                    overflow = TextOverflow.Ellipsis
                )
            }


            note.content?.let { content ->
                Text(
                    style = MaterialTheme.typography.body1,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(
                        bottom = 4.dp,
                        start = 4.dp,
                        end = 4.dp
                    ),
                    text = content,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }

    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun NotesItemList(modifier: Modifier = Modifier, note: Note, onClick: () -> Unit) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .animateContentSize()
            .background(MaterialTheme.colors.background)
            .clickable { onClick() }
    ) {
        Column {
            note.content?.let { content ->
                Text(
                    modifier = Modifier.padding(4.dp), text = content,
                    maxLines = 9,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Divider()
            note.imageUrl?.let { imageUrl ->
                Image(
                    painter = rememberImagePainter(
                        data = imageUrl,
                        builder = {
                            crossfade(true)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
        }

    }
}


@Composable
@Preview
fun PreviewNotesItemGrid() {
    NotesItemGrid(note = Note("Hello")) {}
}

@Composable
@Preview
fun PreviewNotesItemList() {
    NotesItemList(note = Note("Hello")) {}
}