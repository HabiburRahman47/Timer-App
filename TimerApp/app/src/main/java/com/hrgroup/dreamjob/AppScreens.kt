package com.hrgroup.dreamjob

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.hrgroup.dreamjob.viewModels.TimerViewModel

@Composable
fun CounterApp(timerViewModel: TimerViewModel){
    var second by remember { mutableStateOf(0) }
    var minute by remember { mutableStateOf(0) }
    var hours by remember {
        mutableStateOf(0)
    }
    val secondLiveData by timerViewModel.getCounterLiveData().observeAsState()
    val mintueLvieDate by timerViewModel.getMinuteLiveData().observeAsState()
    val hoursLiveData by timerViewModel.getHoursLiveData().observeAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            value = TextFieldValue(
                text = String.format("%02d:%02d:%02d", hours, minute, second),
            ),
            onValueChange = {
            },
            textStyle = TextStyle(
                fontSize = 80.sp,
                textAlign = TextAlign.Center
            ),
        readOnly = true
        )
        secondLiveData?.let {
            second =it
        }
        mintueLvieDate?.let {
            minute = it
        }
        hoursLiveData?.let {
            hours = it
        }
    }
}