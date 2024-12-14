package com.doganur.coffeeshopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
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
                        text = stringResource(R.string.app_name),
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
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .clip(shape = RoundedCornerShape(20.dp)),
                painter = painterResource(id = R.drawable.coffee),
                contentDescription = stringResource(R.string.cont_desc_img_coffee),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.coffee_title),
                    fontFamily = currentFont,
                    fontSize = 24.sp,
                    color = if (isSystemInDarkTheme()) Color.White else TextColor
                )
                Text(
                    text = stringResource(R.string.cont_desc_coffee_price),
                    fontFamily = currentFont,
                    fontSize = 24.sp,
                    color = if (isSystemInDarkTheme()) Color.White else TextColor
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = stringResource(R.string.cont_desc_coffee),
                fontFamily = currentFont,
                fontSize = 16.sp,
                color = TextColor
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(4) {
                    Icon(
                        painterResource(id = R.drawable.ic_star),
                        contentDescription = stringResource(R.string.cont_desc_icon_star),
                        tint = Color(0xFFEEDB33)
                    )
                }

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = stringResource(R.string.cont_desc_coffee_rating),
                    fontFamily = currentFont,
                    fontSize = 16.sp,
                    color = TextColor
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "${stringResource(R.string.four_table_spoon)}\n${stringResource(R.string.milk)}",
                    fontFamily = currentFont,
                    fontSize = 16.sp,
                    color = TextColor
                )

                Text(
                    text = "${stringResource(R.string.two_table_spoon)}\n${stringResource(R.string.sugar)}",
                    fontFamily = currentFont,
                    fontSize = 16.sp,
                    color = TextColor
                )

                Text(
                    text = stringResource(R.string.cheese),
                    fontFamily = currentFont,
                    fontSize = 16.sp,
                    color = TextColor
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = stringResource(R.string.cup_size),
                fontFamily = currentFont,
                fontSize = 16.sp,
                color = TextColor
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                listOf(
                    stringResource(R.string.small_letter),
                    stringResource(R.string.medium_letter),
                    stringResource(R.string.large_letter),
                    stringResource(R.string.x_large_letter)
                ).forEach { size ->
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .border(1.dp, Color.Gray, CircleShape)
                            .background(
                                if (size == stringResource(R.string.medium_letter)) Color(0xFFD7CCC8) else Color.Transparent,
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
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(20.dp))
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8D6E63)
                ),
                onClick = { /*TODO*/ }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_basket),
                        contentDescription = null,
                        tint = Color.White
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = stringResource(R.string.add_to_cart),
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
