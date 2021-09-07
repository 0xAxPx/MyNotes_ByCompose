package com.peshale.mynotes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import com.peshale.mynotes.routing.Screen
import com.peshale.mynotes.theme.NotesTheme
import com.peshale.mynotes.ui.components.AppDrawer
import com.peshale.mynotes.ui.components.Note
import com.peshale.mynotes.viewmodel.MainViewModel
import com.peshale.mynotes.viewmodel.MainViewModelFactory
import kotlinx.coroutines.launch


/**
 * Main activity for the app.
 */
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels(factoryProducer = {
        MainViewModelFactory(
            this,
            (application as MyNotesApplication).dependencyInjector.repository
        )
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            NotesTheme {
                val coroutineScope = rememberCoroutineScope()
                val scaffoldState: ScaffoldState = rememberScaffoldState()

                Scaffold(
                    scaffoldState = scaffoldState,
                    drawerContent = {
                        AppDrawer(
                            currentScreen = Screen.Notes,
                            closeDrawerAction = {
                                coroutineScope.launch {
                                    scaffoldState.drawerState.close()
                                }
                            }
                        )
                    },
                    content = {
                        Note()
                    }
                )
            }
        }
    }
}
