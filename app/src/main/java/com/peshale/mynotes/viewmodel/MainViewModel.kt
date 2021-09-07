package com.peshale.mynotes.viewmodel

import androidx.lifecycle.ViewModel
import com.peshale.mynotes.data.repository.Repository


/**
 * View model used for storing the global app state.
 *
 * This view model is used for all screens.
 */
class MainViewModel(private val repository: Repository) : ViewModel() {

}
