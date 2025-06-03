package com.example.ecommercetest.splash

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommercetest.R
import com.example.ecommercetest.destinations.LoginDestination
import com.example.ecommercetest.ui.theme.darkBlue
import kotlinx.coroutines.delay

/**
 * The Splash Screen Content composable.
 *
 * This composable is the UI for the splash screen. It displays the Route logo and navigates to the
 * Login screen after 2 seconds.
 *
 * @param navController the NavController instance which is used to navigate to the Login screen.
 * @param modifier the modifier for the composable. Defaults to Modifier.
 */
@Composable
fun SplashScreenContent(navController: NavController, modifier: Modifier = Modifier) {
    // Navigate to the Login screen after 2 seconds
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(LoginDestination)
    }

    // The background color of the splash screen
    val backgroundColor = darkBlue

    Column(
        modifier = Modifier
            .background(color = backgroundColor)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // The top blur image
        Image(
            painter = painterResource(id = R.drawable.top_blur),
            contentDescription = null,
            modifier = modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        // The Route logo
        Image(
            painter = painterResource(id = R.drawable.route_logo),
            contentDescription = stringResource(R.string.signature_route_logo),
            modifier = modifier.fillMaxWidth(0.8F),
            contentScale = ContentScale.FillWidth
        )
        // The bottom blur image
        Image(
            painter = painterResource(id = R.drawable.bottom_blur),
            contentDescription = null,
            modifier = modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
}

/**
 * A preview of the [SplashScreenContent] composable.
 *
 * This preview shows how the [SplashScreenContent] composable looks like when it is rendered. It is
 * useful for testing the UI of the splash screen.
 */
@Preview
@Composable
private fun SplashScreenContentPrev() {
    // Show a preview of the splash screen
    SplashScreenContent(rememberNavController())
}