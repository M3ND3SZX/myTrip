package br.senai.sp.jandira.mytrip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mytrip.ui.theme.MytripTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MytripTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MytripLogin()
                }
            }
        }
    }
}

@Composable
fun MytripLogin () {
    Surface (modifier = Modifier .fillMaxSize())
    {
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
                value = "teste@email.com",
                onValueChange = {},
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

                value = "*******",
                onValueChange = {},
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = "password")
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
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "lock",
                        modifier = Modifier
                            .offset(y=-0.dp),
                        tint = Color(0xffCF06F0)
                    )
                }
            )

            Spacer(modifier = Modifier .padding(20.dp))

            Button(onClick = { /*TODO*/ },
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

                Image(
                    imageVector = Icons.Filled.ArrowForward, contentDescription = "",
                    modifier = Modifier
                        .offset(y = -0.dp)
                )
            }
        }







    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MytripTheme {
        MytripLogin()
    }
}