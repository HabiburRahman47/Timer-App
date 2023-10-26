package com.hrgroup.dreamjob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hrgroup.dreamjob.viewModels.TimerViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: TimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterApp(viewModel)
        }
    }
}


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun DefaultPreview(){

}