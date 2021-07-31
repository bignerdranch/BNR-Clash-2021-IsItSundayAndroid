package com.bignerdranch.isitsunday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.bignerdranch.isitsunday.ui.theme.SundayTheme
import com.bignerdranch.isitsunday.ui.viewmodel.SundayViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class SundayActivity : ComponentActivity(), CoroutineScope {

    private lateinit var sundayViewModel: SundayViewModel

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: SundayViewModel by viewModels()
        sundayViewModel = viewModel

        setContent {
            Sunday {
                sundayViewModel.getSundayResponse()
            }
        }
    }

    @Preview
    @Composable
    fun Sunday(
        onClick: (() -> Unit)? = null
    ) {
        val sundayText by remember { sundayViewModel.sundayState }

        SundayTheme {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.gradient_start),
                                colorResource(id = R.color.gradient_end)
                            )
                        )
                    )
            ) {
                Image(
                    painterResource(id = R.drawable.ic_cfa),
                    contentDescription = stringResource(id = R.string.cfa_icon_content_description),
                    modifier = Modifier
                        .padding(top = 70.dp, start = 50.dp, end = 50.dp, bottom = 20.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    stringResource(id = R.string.is_it_sunday),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = colorResource(id = R.color.white),
                )

                Text(
                    text = stringResource(id = sundayText),
                    fontSize = 50.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 50.dp, bottom = 30.dp),
                    color = colorResource(id = R.color.white)
                )

                Button(
                    onClick = { onClick?.invoke() },
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blue_button)),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = stringResource(id = R.string.sunday_button_cta),
                        color = colorResource(id = R.color.white)
                    )
                }
            }
        }
    }

}



