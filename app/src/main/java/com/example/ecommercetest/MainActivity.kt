package com.example.ecommercetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommercetest.destinations.LoginDestination
import com.example.ecommercetest.destinations.RegisterDestination
import com.example.ecommercetest.destinations.SplashDestination
import com.example.ecommercetest.login.LoginScreenContent
import com.example.ecommercetest.splash.SplashScreenContent
import com.example.ecommercetest.ui.theme.EcommerceTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcommerceTestTheme {
                val navHostController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navHostController, startDestination = SplashDestination) {
                        composable<SplashDestination> {
                            SplashScreenContent(navHostController)
                        }
                        composable<LoginDestination> {
                            LoginScreenContent(navHostController)
                        }
                        composable<RegisterDestination> {

                        }
                    }
                }
            }
        }
    }
}

