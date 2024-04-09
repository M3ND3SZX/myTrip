package br.senai.sp.jandira.mytrip.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable


fun MytripLogin (controleDeNavegacao: NavHostController) {

    var userNameState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }

    var messageErrorState = remember {
        mutableStateOf("")
    }

    Column {
        Card(
            modifier = Modifier
                .size(130.dp, 40.dp)
                .align(Alignment.End),
            colors = CardDefaults.cardColors(Color(0xffCF06F0)),
            shape = RoundedCornerShape(bottomStart = 16.dp)
        ) {}

        Column(
            modifier = Modifier
                .padding(start = 25.dp, top = 160.dp)
        ) {
            Text(
                text = "Login",
                color = Color(0xffCF06F0),
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,

                )
            Text(
                text = "Please sign in to continue.",
                color = Color(0xffA09C9C)
            )
        }

        Spacer(modifier = Modifier .padding(30.dp))
        OutlinedTextField(
            value = userNameState.value,
            onValueChange = {
                userNameState.value = it
            },
            isError = isErrorState.value,
            shape = RoundedCornerShape(16.dp),
            label = {
                Text(text = "email")
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(327.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedBorderColor = Color(0xffCF06F0),
                focusedBorderColor = Color(0xffCF06F0),
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "lock",
                    modifier = Modifier
                        .offset(y=-0.dp),
                    tint = Color(0xffCF06F0)
                )
            }

        )
        Spacer(modifier = Modifier .padding(15.dp))

        OutlinedTextField(

            value = senhaState.value,
            onValueChange = {
                senhaState.value = it
            },
            isError = isErrorState.value,
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(16.dp),
            label = {
                Text(text = "password")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                capitalization = KeyboardCapitalization.Sentences
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(327.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedBorderColor = Color(0xffCF06F0),
                focusedBorderColor = Color(0xffCF06F0),
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Lock, contentDescription = "lock",
                    modifier = Modifier
                        .offset(y=-0.dp),
                    tint = Color(0xffCF06F0)
                )
            }
        )

        Spacer(modifier = Modifier .padding(10.dp))
        Row (
            modifier = Modifier .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {
            Text(text = messageErrorState.value,
                color = Color.Red,

            )
            }

        Spacer(modifier = Modifier .padding(10.dp))
        Button(onClick = {
            if (userNameState.value == "mendes@mendes" && senhaState.value == "1234"){
            controleDeNavegacao.navigate("home")
        } else{
            isErrorState.value = true
            messageErrorState.value = "Usuário ou senha inválidos"
        }},
            modifier = Modifier
                .size(134.dp, 48.dp)
                .align(Alignment.End)
                .offset(x = -35.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffCF06F0)),
            shape = RoundedCornerShape(16.dp)

        ) {
            Text(
                text = "SING IN",
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.width(10.dp))

            Icon(
                imageVector = Icons.Filled.ArrowForward, contentDescription = "",
                modifier = Modifier
                    .offset(y = -0.dp),
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){

            Text(
                modifier = Modifier,
                text = "Don’t have an account?  ",
                color = Color(0xFFA09C9C)
            )
            Text(
                modifier = Modifier.padding(end = 25.dp)
                    .clickable { controleDeNavegacao.navigate("cadastro") },
                text = "Sign up",
                color = Color(0xFFCF06F0),
                fontWeight = FontWeight.Bold
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)
                .offset(y = 75.dp)
                .background(
                    Color(0xFFCF06F0),
                    shape = RoundedCornerShape(topEnd = 30.dp)
                )
                .padding(top = 90.dp)
        ){

        }
    }

}

