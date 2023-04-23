package com.snusnu.composestuding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.snusnu.composestuding.ui.instagram_screen.InstagramProfileCard
import com.snusnu.composestuding.ui.instagram_screen.InstagramViewModel
import com.snusnu.composestuding.ui.theme.ComposeStudingTheme

class MainActivity : ComponentActivity() {

    private val instagramViewModel by viewModels<InstagramViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestText(instagramViewModel = instagramViewModel)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TestText(instagramViewModel: InstagramViewModel) {
    ComposeStudingTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            val instagramModels = instagramViewModel.instagramModels.observeAsState(emptyList())
            LazyColumn {
                items(instagramModels.value, key = {it.id}) { instagramModel ->
                    val dismissState = rememberDismissState()
                    if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                        instagramViewModel.delete(instagramModel)
                    }
                    SwipeToDismiss(
                        state = dismissState,
                        directions = setOf(DismissDirection.EndToStart),
                        background = {
                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .background(Color.Red.copy(alpha = 0.5f))
                                    .fillMaxSize(),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(
                                    modifier = Modifier.padding(16.dp),
                                    text = "Delete item",
                                    color = Color.White,
                                    fontSize = 30.sp
                                )
                            }
                        }
                    ) {
                        InstagramProfileCard(
                            instagramModel = instagramModel,
                            onFollowButtonClickListener = instagramViewModel::changeFollowingStatus
                        )
                    }

                }
            }
        }

    }
}