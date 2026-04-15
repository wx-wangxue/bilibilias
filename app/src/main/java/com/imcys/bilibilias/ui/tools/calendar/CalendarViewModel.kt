package com.imcys.bilibilias.ui.tools.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imcys.bilibilias.data.model.bgm.BgmCalendarWeekData
import com.imcys.bilibilias.data.repository.BgmRepository
import com.imcys.bilibilias.network.NetWorkResult
import com.imcys.bilibilias.network.emptyNetWorkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CalendarViewModel(private val bgmRepository: BgmRepository) : ViewModel() {

    val calendarData: StateFlow<NetWorkResult<List<BgmCalendarWeekData>>>
        field = MutableStateFlow<NetWorkResult<List<BgmCalendarWeekData>>>(emptyNetWorkResult())

    init {
        getCalendarInfo()
    }

    fun getCalendarInfo() {
        viewModelScope.launch {
            bgmRepository.getNextCalendar().collect {
                calendarData.value = it
            }
        }
    }
}