package com.imcys.bilibilias.network.service

import com.imcys.bilibilias.network.FlowNetWorkResult
import com.imcys.bilibilias.network.adapter.bgmHttpRequest
import com.imcys.bilibilias.network.config.API
import com.imcys.bilibilias.network.model.bgm.BgmCalendar
import com.imcys.bilibilias.network.model.bgm.next.BgmNextCalendar
import com.imcys.bilibilias.network.model.bgm.next.BgmNextSubject
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class BgmAPIService(
    val httpClient: HttpClient
) {
    suspend fun getCalendar(): FlowNetWorkResult<List<BgmCalendar>> = httpClient.bgmHttpRequest {
        get(API.Bgm.CALENDER)
    }

    suspend fun getNextCalendar(): FlowNetWorkResult<BgmNextCalendar> = httpClient.bgmHttpRequest {
        get(API.Bgm.Next.CALENDER)
    }

    suspend fun getNextSubject(subjectId: Long): FlowNetWorkResult<BgmNextSubject> = httpClient.bgmHttpRequest {
        get("${API.Bgm.Next.SUBJECT_DETAIL}/$subjectId")
    }
}