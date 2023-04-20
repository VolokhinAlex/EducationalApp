package com.volokhinaleksey.educationalapp.viewmodel

import com.volokhinaleksey.educationalapp.base.BaseViewModel
import com.volokhinaleksey.educationalapp.models.ui.HomeworkDataUI
import com.volokhinaleksey.educationalapp.repository.HomeWorkRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class HomeWorkScreenViewModel(
    private val homeWorkRepository: HomeWorkRepository,
    private val ioDispatcher: CoroutineDispatcher
) : BaseViewModel<List<HomeworkDataUI>>() {

    init {
        getHomeWorks()
    }

    private fun getHomeWorks() {
        viewModelScope.launch(ioDispatcher) {
            _data.postValue(homeWorkRepository.getHomeWorks())
        }
    }

}