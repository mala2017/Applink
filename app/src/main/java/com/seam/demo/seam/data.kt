package com.seam.demo.seam

data class ChipItem(
    val id: String,
    val name: String,

)
val chipItems = listOf<ChipItem>(
    ChipItem("1", "WorkSpace"),
    ChipItem("2", "Account"),
    ChipItem("3", "Connected Accounts"),
    ChipItem("4", "Locks"),
    ChipItem("5", "Access Codes"),

)
