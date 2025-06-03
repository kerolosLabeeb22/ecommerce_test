package com.example.ecommercetest.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ecommercetest.R
import com.example.ecommercetest.destinations.HomeDestination
import com.example.ecommercetest.ui.theme.darkBlue
import com.example.ecommercetest.ui.theme.white
import com.example.ecommercetest.utils.EcommerceButton
import com.example.ecommercetest.utils.EcommerceTextField

@Composable
fun LoginScreenContent(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = darkBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.route_logo),
            contentDescription = stringResource(
                R.string.signature_route_logo
            ), modifier =
                modifier
                    .fillMaxWidth(0.7F)
                    .padding(top = 82.dp),
            contentScale = ContentScale.FillWidth
        )

        Text(
            text = stringResource(R.string.welcome_back_to_route),
            color = white,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            modifier = modifier
                .padding(top = 16.dp)
                .align(Alignment.Start)
                .padding(horizontal = 8.dp)
        )

        Text(
            text = stringResource(R.string.please_sign_in_with_your_mail),
            color = white,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily(Font(R.font.poppins_light)),
            modifier = modifier
                .align(Alignment.Start)
                .padding(horizontal = 8.dp)
        )
        EcommerceTextField(
            state = viewModel.email,
            label = stringResource(R.string.email_address),
            placeHolder = stringResource(R.string.please_enter_your_email),
            errorState = viewModel.emailError.value
        ){

        }

        EcommerceTextField(
            state = viewModel.password,
            label = stringResource(R.string.password),
            placeHolder = stringResource(R.string.enter_your_password),
            errorState = viewModel.passwordError.value
        ){

        }

        EcommerceButton(text = "login", modifier = modifier.padding(top = 72.dp)) {
            navController.navigate(HomeDestination)
        }

    }
}

@Preview
@Composable
private fun LoginScreenContentPrev() {
    LoginScreenContent(rememberNavController())
}