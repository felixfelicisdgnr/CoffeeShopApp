package com.doganur.coffeeshopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doganur.coffeeshopapp.ui.theme.AppTheme
import com.doganur.coffeeshopapp.ui.theme.DarkBrownColor
import com.doganur.coffeeshopapp.ui.theme.PrimaryColor
import com.doganur.coffeeshopapp.ui.theme.TextColor
import com.doganur.coffeeshopapp.ui.theme.currentFont

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                HomePage()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Coffee Shop",
                        fontFamily = currentFont,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryColor,
                    titleContentColor = TextColor
                )
            )
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(20.dp)),
                painter = painterResource(id = R.drawable.coffee),
                contentDescription = stringResource(R.string.cont_desc_img_coffee),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Cappuccino Coffee",
                    fontFamily = currentFont,
                    fontSize = 24.sp,
                    color = TextColor

                )
                Text(
                    text = "$12.00",
                    fontFamily = currentFont,
                    fontSize = 24.sp,
                    color = DarkBrownColor
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Cold Brew",
                fontFamily = currentFont,
                fontSize = 16.sp,
                color = TextColor
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painterResource(id = R.drawable.ic_star),
                    contentDescription = null,
                    tint = Color(0xFFEEDB33)
                )

                Icon(
                    painterResource(id = R.drawable.ic_star),
                    contentDescription = null,
                    tint = Color(0xFFEEDB33)
                )

                Icon(
                    painterResource(id = R.drawable.ic_star),
                    contentDescription = null,
                    tint = Color(0xFFEEDB33)
                )

                Icon(
                    painterResource(id = R.drawable.ic_star),
                    contentDescription = null,
                    tint = Color(0xFFEEDB33)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "5.0",
                    fontFamily = currentFont,
                    fontSize = 16.sp,
                    color = TextColor
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "4 tbs\nMilk",
                    fontFamily = currentFont,
                    fontSize = 16.sp,
                    color = TextColor
                )

                Text(
                    "2 tbs\nSugar",
                    fontFamily = currentFont,
                    fontSize = 16.sp,
                    color = TextColor
                )

                Text(
                    "Cheese\nTopping",
                    fontFamily = currentFont,
                    fontSize = 16.sp,
                    color = TextColor
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Cup Size",
                fontFamily = currentFont,
                fontSize = 16.sp,
                color = TextColor
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("S", "M", "L", "XL").forEach { size ->
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .border(1.dp, Color.Gray, CircleShape)
                            .background(
                                if (size == "M") Color(0xFFD7CCC8) else Color.Transparent,
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = size,
                            fontFamily = currentFont, fontSize = 16.sp, color = TextColor
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8D6E63)),
                onClick = { /*TODO*/ }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_basket),
                        contentDescription = null,
                        tint = Color.White
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Add to Cart",
                        fontFamily = currentFont, fontSize = 16.sp, color = TextColor
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        HomePage()
    }
}