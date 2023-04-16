package com.snusnu.composestuding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.snusnu.composestuding.ui.InstagramProfileCard
import com.snusnu.composestuding.ui.theme.ComposeStudingTheme
import com.snusnu.composestuding.ui.theme.PostCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudingTheme {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(MaterialTheme.colors.background)
//                ) {
//                    PostCard()
//                }
                Test()
            }
        }
    }
}

@Composable
private fun Test() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Example3()
    }
}

@Composable
private fun Example1() {
    OutlinedButton(onClick = { /*TODO*/ }) {
        Text(
            text = "So, Hi!",
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun Example2() {
    TextField(
        value = "Value",
        onValueChange = { "Value"},
        label = { Text(text = "Label")}
    )
}

@Composable
private fun Example3() {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = "Are you sure?")
        },
        text = {
            Text(
                "Do you want to delete this file?"
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                }
            ) {
                Text(
                    "Yes",
                    color = Color.Black
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                }
            ) {
                Text(
                    "No",
                    color = Color.Black
                )
            }
        }
    )
}