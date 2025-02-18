package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
@Preview
fun ArtSpaceApp() {
    var imageId by remember { mutableIntStateOf(1) }

    // constant lambda functions with no parameters or return type that
    // modify a state variable to be implemented in composables later
    val previousClick: () -> Unit = { if (imageId > 1) imageId-- }
    val nextClick: () -> Unit = { if (imageId < 5) imageId++ }

    when (imageId) {
        1 -> {
            GalleryPiece(
                image = R.drawable.the_sleeping_gypsy,
                imageDesc = R.string.sleeping_desc,
                author = R.string.sleeping_artist,
                title = R.string.sleeping,
                year = R.string.sleeping_year,
                previousClick = { previousClick() },
                nextClick = { nextClick() }
            )
        }
        2 -> {
            GalleryPiece(
                image = R.drawable.the_frame_frida_kahlo,
                imageDesc = R.string.the_frame_desc,
                author = R.string.the_frame_artist,
                title = R.string.the_frame,
                year = R.string.the_frame_year,
                previousClick = { previousClick() },
                nextClick = { nextClick() }
            )
        }
        3 -> {
            GalleryPiece(
                image = R.drawable.ireses_van_gogh,
                imageDesc = R.string.ireses_desc,
                author = R.string.ireses_artist,
                title = R.string.ireses,
                year = R.string.ireses_year,
                previousClick = { previousClick() },
                nextClick = { nextClick() }
            )
        }
        4 -> {
            GalleryPiece(
                image = R.drawable.a_sunday_afternoon,
                imageDesc = R.string.sunday_afternoon_desc,
                author = R.string.sunday_afternoon_artist,
                title = R.string.sunday_afternoon,
                year = R.string.sunday_afternoon_year,
                previousClick = { previousClick() },
                nextClick = { nextClick() }
            )
        }
        else -> {
            GalleryPiece(
                image = R.drawable.girl_with_a_pearl,
                imageDesc = R.string.pearl_earring_desc,
                author = R.string.pearl_earring_artist,
                title = R.string.pearl_earring,
                year = R.string.pearl_earring_year,
                previousClick = { previousClick() },
                nextClick = { nextClick() }
            )
        }
    }

}

@Composable
fun GalleryPiece(
    @DrawableRes image: Int,
    @StringRes imageDesc: Int,
    @StringRes author: Int,
    @StringRes title: Int,
    @StringRes year: Int,
    previousClick: () -> Unit,
    nextClick: () -> Unit
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(24.dp)
                .background(colorResource(R.color.background_blue))
        ) {
            Image (
                painter = painterResource(image),
                contentDescription = stringResource(imageDesc),
                modifier = Modifier
                    .wrapContentSize()
                    .padding(16.dp)
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp)
        ) {
            GalleryCard(
                image = image,
                imageDesc = imageDesc,
                author = author,
                title = title,
                year = year
            )
            ChangePiece(
                previousClick = previousClick,
                nextClick = nextClick
            )
        }
    }
}

@Composable
fun GalleryCard (
    @DrawableRes image: Int,
    @StringRes imageDesc: Int,
    @StringRes author: Int,
    @StringRes title: Int,
    @StringRes year: Int
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(bottom = 24.dp)
            .background(colorResource(R.color.background_blue))
    ) {
        Text (
            text = stringResource(title),
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 8.dp),
            fontSize = 24.sp
        )
        Row (
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
        ) {
            Text (
                text = stringResource(author),
                modifier = Modifier.padding(start = 12.dp, end = 2.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
            Text (
                text = stringResource(year),
                modifier = Modifier.padding(start = 2.dp, end = 12.dp, bottom = 12.dp),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun ChangePiece(
    previousClick: () -> Unit,
    nextClick: () -> Unit
) {
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button (
            onClick = { previousClick() },
            modifier = Modifier
                .width(104.dp)
        ) {
            Text(stringResource(R.string.previous))
        }
        Button (
            onClick = { nextClick() },
            modifier = Modifier.width(104.dp)
        ) {
            Text(stringResource(R.string.next))
        }
    }
}