package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .background(Color(0xFF3F3939))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        IdentificationComposable(
            name = "John Doe",
            title = "Junior Developer"
        )
        ContactInformationComposable("+1 (123) 456-7890", "@johndoe",
            "johndoe@gmail.com")
    }
}

@Composable
fun IdentificationComposable(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image (
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(104.dp)
                .width(104.dp)
        )
        Text (
            text = name,
            color = Color(0xFF3DDC84),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = modifier.padding(2.dp)
        )
        Text (
            text = title,
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ContactInformationComposable(number: String, socialHandle: String, email: String,
                                 modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.Start
    ) {
        Row (
            verticalAlignment = Alignment.Bottom
        ) {
            Icon (
                Icons.Filled.Phone,
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(18.dp)
            )
            Text (
                text = number,
                color = Color.White,
                modifier = modifier.padding(8.dp)
            )
        }
        Row (
            verticalAlignment = Alignment.Bottom
        ) {
            Icon (
                Icons.Filled.Share,
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(18.dp)
            )
            Text (
                text = socialHandle,
                color = Color.White,
                modifier = modifier.padding(8.dp)
            )
        }
        Row (
            verticalAlignment = Alignment.Bottom
        ) {
            Icon (
                Icons.Filled.Email,
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(18.dp)
            )
            Text (
                text = email,
                color = Color.White,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}