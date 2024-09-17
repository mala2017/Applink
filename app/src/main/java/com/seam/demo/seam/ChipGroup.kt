package com.seam.demo.seam

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChipGroup(
    chipItems: List<ChipItem>,         // List of ChipItem objects
    onChipSelected: (ChipItem) -> Unit // Callback to handle chip selection
) {
    var selectedChip by remember { mutableStateOf<ChipItem?>(null) }

    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        chipItems.forEach { chip ->
            ChipItem(
                text = chip.name,
                isSelected = selectedChip == chip,
                onClick = {
                    selectedChip = chip
                    onChipSelected(chip) // Notify the parent of the selected chip
                }
            )
        }
    }
}