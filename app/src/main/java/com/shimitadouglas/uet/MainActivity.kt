package com.shimitadouglas.uet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shimitadouglas.uet.container.Container
import com.shimitadouglas.uet.navigation.Nav
import com.shimitadouglas.uet.ui.theme.UETTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UETTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //creating a navController facilitates navigation
                    val navigationController:NavHostController= rememberNavController()
                    //invocation of Nav that contains defined routes
                    Nav(navigationController)
                    //invoking container File that contains app functionalities
                    val context=applicationContext
                    Container(navigationController,context)
                }
            }
        }

    }
}

