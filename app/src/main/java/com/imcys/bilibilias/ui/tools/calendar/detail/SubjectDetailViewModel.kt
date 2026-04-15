package com.imcys.bilibilias.ui.tools.calendar.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imcys.bilibilias.data.repository.BgmRepository
import com.imcys.bilibilias.network.NetWorkResult
import com.imcys.bilibilias.network.emptyNetWorkResult
import com.imcys.bilibilias.network.model.bgm.next.BgmNextSubject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SubjectDetailViewModel(private val bgmRepository: BgmRepository) : ViewModel() {

    val subjectData: StateFlow<NetWorkResult<BgmNextSubject>>
        field = MutableStateFlow<NetWorkResult<BgmNextSubject>>(emptyNetWorkResult())

    fun loadSubjectDetail(subjectId: Long) {
        viewModelScope.launch {
            bgmRepository.getNextSubject(subjectId).collect {
                subjectData.value = it
            }
        }
    }
}