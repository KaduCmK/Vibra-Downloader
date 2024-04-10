package com.example.vibradownloader

import android.app.Application
import android.util.SparseArray
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.maxrave.kotlinyoutubeextractor.State
import com.maxrave.kotlinyoutubeextractor.VideoMeta
import com.maxrave.kotlinyoutubeextractor.YTExtractor
import com.maxrave.kotlinyoutubeextractor.YtFile
import kotlinx.coroutines.launch


class MainViewModel(private val application: Application) : AndroidViewModel(application) {

//    explicar
    var extractState = mutableStateOf(State.INIT)
//    var videoUrl = mutableStateOf("")
    lateinit var ytFiles: SparseArray<YtFile>
    lateinit var videoMeta: VideoMeta

    fun extract(videoId: String) {
        extractState.value = State.LOADING

        val yt = YTExtractor(
            con = application.applicationContext,
            LOGGING = true
        )

        viewModelScope.launch {
            yt.extract(videoId)
            extractState.value = yt.state

            if (yt.state == State.SUCCESS) {
                ytFiles = yt.ytFiles!!
                videoMeta = yt.getVideoMeta()!!
//                videoUrl.value = ytFiles[251].url!!
            }
        }
    }

    fun idExtract(videoId: String): String {
//        val subId = videoId.substringAfter("?v=")
        return videoId.substringAfter("?v=").substringBefore("?")
    }
}