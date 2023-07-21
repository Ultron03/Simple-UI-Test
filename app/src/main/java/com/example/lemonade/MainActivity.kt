package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

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
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    var currentStep by remember {
        mutableStateOf(1)
    }
    val sque =(2..6).random()
    var count =1
    Column( horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Text(
            text = "Lemonade",
            textAlign = TextAlign.Center,
            modifier = modifier
                .background(Color(239, 236, 40))
                .fillMaxWidth()
                .padding(12.dp)
        )
    }

    when (currentStep){
        1->Column(
                modifier = modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
             ) {

                    Image(
                        painter = painterResource(id = R.drawable.lemon_tree),
                        contentDescription = "tree",
                        modifier = modifier
                            .size(250.dp)
                            .background(Color(145, 248, 159), RoundedCornerShape(20.dp))
                            .padding(16.dp)
                            .clickable {
                                currentStep = 2
                            },
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = stringResource(R.string.lemon_tree))

                }
        2->Column(
                modifier = modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
                ) {
                    Image(

                        painter = painterResource(id = R.drawable.lemon_squeeze),
                        contentDescription = "tree",
                        modifier = modifier
                            .size(250.dp)
                            .background(Color(145, 248, 159), RoundedCornerShape(20.dp))
                            .padding(16.dp)
                            .clickable {
                                if (count > sque) {
                                    currentStep = 3
                                } else {
                                    count++
                                }

                            },

                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = stringResource(R.string.squeeze))

                }
        3->Column(
                modifier = modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lemon_drink),
                        contentDescription = "tree",
                        modifier = modifier
                            .size(250.dp)
                            .background(Color(145, 248, 159), RoundedCornerShape(20.dp))
                            .padding(16.dp)
                            .clickable {
                                currentStep = 4
                            },
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = stringResource(R.string.drink_it))

                }
        4->Column(
                modifier = modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lemon_restart),
                        contentDescription = "tree",
                        modifier = modifier
                            .size(250.dp)
                            .background(Color(145, 248, 159), RoundedCornerShape(20.dp))
                            .padding(16.dp)
                            .clickable {
                                currentStep = 1
                            },
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = stringResource(R.string.restart))

                }
    }



}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Greeting()
    }
}