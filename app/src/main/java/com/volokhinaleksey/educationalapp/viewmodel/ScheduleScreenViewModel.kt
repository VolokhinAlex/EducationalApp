package com.volokhinaleksey.educationalapp.viewmodel

import com.volokhinaleksey.educationalapp.base.BaseViewModel
import com.volokhinaleksey.educationalapp.models.ui.ScheduleUI
import com.volokhinaleksey.educationalapp.repository.ScheduleClassesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class ScheduleScreenViewModel(
    private val repository: ScheduleClassesRepository,
    private val ioDispatcher: CoroutineDispatcher
) : BaseViewModel<List<ScheduleUI>>() {

    init {
        getScheduleClasses()
    }

    private fun getScheduleClasses() {
        viewModelScope.launch(ioDispatcher) {
            _data.postValue(repository.getScheduleClasses())
        }
    }

}