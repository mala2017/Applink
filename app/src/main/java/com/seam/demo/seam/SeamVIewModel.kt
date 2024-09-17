package com.seam.demo.seam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WorkspaceViewModel : ViewModel() {

    private val repository = SeamRepository()

    private val _workspaceList = MutableStateFlow<List<Workspace>>(emptyList())
    val workspaceList: StateFlow<List<Workspace>> = _workspaceList



     fun fetchWorkspaces() {
        viewModelScope.launch {
            try {
                val response = repository.getWorkspaces()
                if (response.ok) {
                    _workspaceList.value = listOf(response.workspace)
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}