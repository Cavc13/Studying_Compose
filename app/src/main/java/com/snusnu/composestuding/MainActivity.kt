package com.snusnu.composestuding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.ui.unit.dp
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
    Scaffold(
        bottomBar = {
            BottomNavigationSample()
        },
        drawerContent = {
            ModalDrawerSample()
        }
    ) {
        Text(text = "Text content")
    }
}

@Composable
private fun BottomNavigationSample() {
    val items = listOf("News", "Weather", "Post")

    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = true,
                onClick = { },
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(item) },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
private fun ModalDrawerSample() {
    ModalDrawer(
        drawerContent = {
            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                content = { Text(text = "Close Drawer") }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = ">>> Swipe >>>")
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {}) {
                    Text(text = "Click to open")
                }
            }
        }
    )
}