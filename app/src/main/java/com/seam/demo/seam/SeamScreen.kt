package com.seam.demo.seam

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WorkspaceScreen(viewModel: WorkspaceViewModel) {


    val workspaceList by viewModel.workspaceList.collectAsState()

    var selectedWorkspace by remember { mutableStateOf<WorkspaceOperation?>(null) }

    Column {
        ChipGroup(
            workspaceList = operation,
            onWorkspaceSelected = { workspace ->
                selectedWorkspace = workspace
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        selectedWorkspace?.let { workspace ->
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(workspaceList) { workspaceList ->
                    WorkspaceItem(workspace = workspaceList)
                }
            }
        }
    }
}

@Composable
fun ChipGroup(
    workspaceList: List<WorkspaceOperation>,
    onWorkspaceSelected: (WorkspaceOperation) -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {
        workspaceList.forEach { workspace ->
            Button(
                onClick = { onWorkspaceSelected(workspace) },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(text = workspace.name)
            }
        }
    }
}

@Composable
fun WorkspaceItem(workspace: Workspace) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Workspace ID: ${workspace.workspace_id}")
        Text(text = "Name: ${workspace.name}")
        Text(text = "Connect Partner: ${workspace.connect_partner_name}")
        Text(text = "Sandbox: ${workspace.is_sandbox}")
    }
}