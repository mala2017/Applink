package com.seam.demo.seam

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(viewModel: WorkspaceViewModel) {

    var selectedChipType by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Seam",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )


        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
           items(chipItems){
               ChipItem(
                   text = it.name,
                   isSelected =it.name == selectedChipType,
                   onClick = { selectedChipType = it.name


                   }
               )
           }
        }


        if (selectedChipType == "WorkSpace") {
            viewModel.fetchWorkspaces()
            WorkspaceScreen(viewModel = viewModel)
        } else if (selectedChipType == "Account") {
            Text("Account screen coming soon", modifier = Modifier.padding(16.dp))
        }

    }
}


