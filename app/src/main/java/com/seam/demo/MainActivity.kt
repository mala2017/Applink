package com.seam.demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.seam.demo.seam.MainScreen
import com.seam.demo.seam.OpenWebPageExample
import com.seam.demo.seam.WorkspaceViewModel
import com.seam.demo.ui.theme.ComposeExperimentsTheme


class MainActivity : ComponentActivity() {
    private val viewModel: WorkspaceViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeExperimentsTheme {

                // OpenWebPageExample()
            }
        }
        // ATTENTION: This was auto-generated to handle app links.
        val appLinkIntent: Intent = intent
        val appLinkAction: String? = appLinkIntent.action
        val appLinkData: Uri? = appLinkIntent.data
    }


}

