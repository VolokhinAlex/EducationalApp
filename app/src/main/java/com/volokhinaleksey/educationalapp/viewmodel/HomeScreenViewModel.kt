package com.volokhinaleksey.educationalapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.volokhinaleksey.educationalapp.base.BaseViewModel
import com.volokhinaleksey.educationalapp.models.ui.HomeworkDataUI
import com.volokhinaleksey.educationalapp.models.ui.ScheduleUI
import com.volokhinaleksey.educationalapp.repository.HomeWorkRepository
import com.volokhinaleksey.educationalapp.repository.ScheduleClassesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val homeWorkRepository: HomeWorkRepository,
    private val scheduleRepository: ScheduleClassesRepository,
    private val ioDispatcher: CoroutineDispatcher
) : BaseViewModel<List<HomeworkDataUI>>() {

    private val _currentLesson: MutableLiveData<ScheduleUI> = MutableLiveData()
    val currentLesson: LiveData<ScheduleUI> get() = _currentLesson

    init {
        getHomeworks()
        getCurrentLesson()
    }

    private fun getHomeworks() {
        viewModelScope.launch(ioDispatcher) {
            _data.postValue(homeWorkRepository.getHomeWorks())
        }
    }

    private fun getCurrentLesson() {
        viewModelScope.launch(ioDispatcher) {
            _currentLesson.postValue(scheduleRepository.getScheduleClasses()[0])
        }
    }

}