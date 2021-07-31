package com.bignerdranch.isitsunday.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.isitsunday.R
import com.bignerdranch.isitsunday.data.SundayService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SundayViewModel : ViewModel() {

    private val _sundayState: MutableState<Int> = mutableStateOf(R.string.empty_string)
    val sundayState: State<Int> = _sundayState

    private fun onSundayChange(onNewSundayResponseText: Int) {
        _sundayState.value = onNewSundayResponseText
    }

    fun getSundayResponse() {
        val service = Retrofit.Builder()
            .baseUrl("http://localhost/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(SundayService::class.java)

        viewModelScope.launch {
            val isSunday = service.getSundayResponse().sunday
            withContext(Dispatchers.Main) {

                Log.d("Response", "$isSunday")

                onSundayChange(
                    if (isSunday) {
                        R.string.yes_its_sunday
                    } else {
                        R.string.no_its_not
                    }
                )
            }
        }
    }
}