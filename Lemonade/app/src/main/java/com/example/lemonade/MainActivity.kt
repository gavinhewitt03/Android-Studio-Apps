package com.example.lemonade


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    // remember keyword holds value constant across recombinations
    // mutableStateOf holds any arbitrary value, but Compose automatically
    // observes any changes to the value
    var currStep by remember { mutableIntStateOf(1)}

    var numSqueezes by remember {mutableIntStateOf(0)}

    when (currStep) {
        1 -> {
            ButtonWithImage (
                modifier = Modifier,
                imageResourceId = R.drawable.lemon_tree,
                imageDescId = R.string.lemon_tree_desc,
                textDescId = R.string.lemon_tree_text,
                imageClick = {
                    numSqueezes = (2..4).random() // to be used in next state
                    currStep++
                }
            )
        }
        2 -> {
            ButtonWithImage (
                modifier = Modifier,
                imageResourceId = R.drawable.lemon_squeeze,
                imageDescId = R.string.lemon_squeeze_desc,
                textDescId = R.string.lemon_squeeze_text,
                imageClick = {
                    numSqueezes--
                    if (numSqueezes == 0)
                        currStep++
                }
            )
        }
        3 -> {
            ButtonWithImage (
                modifier = Modifier,
                imageResourceId = R.drawable.lemon_drink,
                imageDescId = R.string.lemon_drink_desc,
                textDescId = R.string.lemon_drink_text,
                imageClick = {
                    currStep++
                }
            )
        }
        else -> {
            ButtonWithImage (
                modifier = Modifier,
                imageResourceId = R.drawable.lemon_restart,
                imageDescId = R.string.lemon_restart_desc,
                textDescId = R.string.lemon_restart_text,
                imageClick = {
                    currStep = 1
                }
            )
        }
    }
}

/**
 * Composable function representing a button with different images based on the state
 * of a lemon/lemonade.
 */
@Composable
fun ButtonWithImage(modifier: Modifier = Modifier,
                    imageResourceId: Int,
                    imageDescId: Int,
                    textDescId: Int,
                    imageClick: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button (
            onClick = { imageClick() },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.background_teal))
        ) {
            Image (painter = painterResource(imageResourceId),
                contentDescription = stringResource(imageDescId)
            )
        }
        Text (
            text = stringResource(textDescId),
            modifier = Modifier.padding(24.dp),
            fontSize = 18.sp
        )
    }
}

