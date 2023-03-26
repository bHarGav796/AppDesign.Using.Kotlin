package com.example.loginsamplekotlin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun UserLoginPage(navController: NavController){
//fun UserLoginPage(){

//Declaring variables for ValueInputs
    var userId by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    val isFormValid by derivedStateOf {
        userId.isNotBlank() && password.length >= 7
    }

//Design Layout Structure
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ){

            //TopHalf modification made here
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.30f),
                Alignment.TopEnd
            ){
                //Modification made here
                Image(painter = painterResource(id = R.drawable.top_background) , contentDescription ="null",
                    modifier = Modifier.fillMaxSize(),contentScale = ContentScale.FillBounds)
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f)
                    , verticalArrangement = Arrangement.spacedBy(6.dp)
                    ,horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.6f),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Image(painter = painterResource(id = R.drawable.app_logo), contentDescription = "LogoApp"
                            ,modifier = Modifier.size(55.dp))
                        Text(text = "Scan-N-Mark", fontSize = 30.sp,
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .offset(y = (-5).dp))
                    }

                }
            }//TopHalf Ends here

            //BottomHalf modification made here
            Column(modifier = Modifier
                .offset(y = (-60).dp)
                .background(Color.White, shape = RoundedCornerShape(33.dp))
                .clip(shape = RoundedCornerShape(33.dp))
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 32.dp, start = 30.dp, end = 30.dp)
                ) {
                    Text(text = "Welcome", fontWeight = FontWeight.Bold, fontSize = 32.sp)
                    Text(text = "Back", fontWeight = FontWeight.Bold, fontSize = 32.sp)
                    Row(modifier = Modifier.fillMaxWidth()) {
                    TextButton(
                        onClick = {
                            navController.navigate("admin_login_page"){
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                            }
                        }
                    ) {
                        Text(
                            text = "Switch to Admin",
                            modifier = Modifier
                                .offset(y = (-5).dp, x = (-6).dp)
                        )
                    }
                        Image(painter = painterResource(id = R.drawable.arrow_right), contentDescription = "null",
                            modifier = Modifier.offset(x = (-8).dp,y=16.dp))

                    }
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = userId,
                            onValueChange ={userId = it},
                            colors = TextFieldDefaults.textFieldColors(//new modifications////////
                                backgroundColor = Color.Transparent,
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = "null"
                                )
                            },
                            label = { Text(text = "User-Id") },
                            singleLine = true,
                            trailingIcon = {
                                if (userId.isNotBlank())
                                    IconButton(onClick = { userId = "" }) {
                                        Icon(
                                            imageVector = Icons.Filled.Clear,
                                            contentDescription = ""
                                        )
                                    }
                            }
                        )//UserId Outlined Text Field ends

                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = password,
                            onValueChange = {password = it} ,
                            colors = TextFieldDefaults.textFieldColors(//new modifications////////
                                backgroundColor = Color.Transparent,
                            ),
                            label = { Text(text = "Password") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                    Icon(
                                        imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                        contentDescription = "Password Toggle"
                                    )
                                }
                            }
                        )//Password Outlined Text Field ends

                        Row( modifier = Modifier
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(
                                    text = "Forgot Password?",
                                    color = Color.Black,
                                modifier = Modifier.offset(y = (-8).dp))
                            }
                            Button(onClick = {/*TODO*/},
                                enabled = isFormValid,
                                modifier = Modifier
                                    .height(60.dp)
                                    .width(60.dp)
                                    .offset(y = 12.dp),
                                shape = RoundedCornerShape(50.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                            ){
                                Image(painter = painterResource(id = R.drawable.arrow), contentDescription ="sign_in_logo",
                                    modifier = Modifier.weight(.7f)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(text = "Don't have an account yet?",
                            modifier = Modifier.offset(y = (-13).dp))
                            TextButton(
                                onClick = {
                                    navController.navigate("user_signup_page"){
                                    popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }
                                }
                            ) {
                                Text(
                                    text = "Register"
                                )
                            }
                        }
                    }//Inside Column-Card
                }

            }//BottomHalf Ends here
        }//Main Column Ends here
    }//Scaffold Ends here
}
//@Composable
//@Preview(showBackground = true)
//fun UserLoginPageTheme(){
//    UserLoginPage()
//}
//
