package com.seam.demo.seam

data class WorkspaceResponse(
    val workspace: Workspace,
    val ok: Boolean
)

data class Workspace(
    val workspace_id: String,
    val name: String,
    val connect_partner_name: String,
    val is_sandbox: Boolean
)

data class WorkspaceOperation(
    val name: String,
)

val operation = mutableListOf(
    WorkspaceOperation("Get WorkApace"),
    WorkspaceOperation("Reset WorkApace")
)