package com.hrgroup.dreamjob.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Timer
import java.util.TimerTask

class TimerViewModel: ViewModel() {
    private var secondLiveData = MutableLiveData(0)
    private var minuteLiveDate = MutableLiveData(0)
    private var hoursLiveData = MutableLiveData(0)
    private val timer = Timer()

    init {
        timer.scheduleAtFixedRate(object : TimerTask(){
            override fun run() {
                var currentValue = secondLiveData.value?:0
                var minutes = minuteLiveDate.value?:0
                var hours = hoursLiveData.value?:0

                // Increment the seconds counter
                currentValue++

                // Check if the seconds counter reaches 60
                if (currentValue >59) {
                    // Reset the seconds counter
                    currentValue = 0

                    // Increment the minutes counter
                    minutes++

                    // Check if the minutes counter reaches 60
                    if (minutes >59) {
                        // Reset the minutes counter
                        minutes = 0

                        // Increment the hours counter
                        hours++
                        if (hours>59){
                            hours=0
                        }
                    }
                }

                // Update the LiveData
                secondLiveData.postValue(currentValue)
                minuteLiveDate.postValue(minutes)
                hoursLiveData.postValue(hours)
            }

        }, 1000, 1000)
    }
    fun getCounterLiveData(): LiveData<Int> = secondLiveData
    fun getMinuteLiveData(): LiveData<Int> = minuteLiveDate
    fun getHoursLiveData(): LiveData<Int> = hoursLiveData

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}