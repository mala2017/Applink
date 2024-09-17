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
        val appLinkData: Uri? = intent.data
        setContent {
            ComposeExperimentsTheme {

                OpenWebPageExample()
            }
        }
    }
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }
    private fun handleIntent(intent: Intent) {
        val appLinkAction = intent.action
        val appLinkData: Uri? = intent.data
        if (Intent.ACTION_VIEW == appLinkAction) {
            val authCode = appLinkData?.getQueryParameter("code")
            if(!authCode.isNullOrEmpty()){
                //viewModel.enableAlexaSkill(authCode)
            }else{
                finish()
            }
        }
    }
}

