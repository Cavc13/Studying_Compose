package com.snusnu.composestuding.ui.instagram_screen

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.snusnu.composestuding.domain.InstagramModel
import kotlin.random.Random

class InstagramViewModel: ViewModel() {

    private val initList = mutableListOf<InstagramModel>().apply {
        repeat(500) {
            add(
                InstagramModel(
                    id = it,
                    title = "Title: $it",
                    isFollowed = Random.nextBoolean()
                )
            )
        }
    }

    private val _instagramModels = MutableLiveData<List<InstagramModel>>(initList)
    val instagramModels: LiveData<List<InstagramModel>> = _instagramModels


    fun changeFollowingStatus(instagramModel: InstagramModel) {
        val modifiedList = _instagramModels.value?.toMutableList() ?: mutableListOf()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            modifiedList.replaceAll {
                if (it == instagramModel) {
                    it.copy(isFollowed = !it.isFollowed)
                }  else {
                    it
                }
            }
        }
        _instagramModels.value = modifiedList
    }

    fun delete(instagramModel: InstagramModel) {
        val modifiedList = _instagramModels.value?.toMutableList() ?: mutableListOf()
        modifiedList.remove(instagramModel)
        _instagramModels.value = modifiedList
    }
}