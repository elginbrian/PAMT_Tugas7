package com.filkom.mycv2.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Login(onLogin: (nim: String, nama: String, email: String) -> Unit, onDaftar:()-> Unit)
{
    val nimState = remember { mutableStateOf("") }
    val namaState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwdState = remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Text(text = "LOGIN")
        OutlinedTextField(
            value = nimState.value,
            onValueChange = { nimState.value = it },
            label = { Text("NIM") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
        OutlinedTextField(
            value = namaState.value,
            onValueChange = { namaState.value = it },
            label = { Text("NAMA") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
        OutlinedTextField(
            value = passwdState.value,
            onValueChange = { passwdState.value = it },
            label = { Text("password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )

        Button (
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 10.dp),
            onClick = { onLogin(nimState.value, namaState.value, emailState.value) })
        {
            Text("LOGIN")
        }
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {onDaftar()})
        {
            Text("DAFTAR")
        }
    }
}

@Preview
@Composable
fun loginPreview() {
    Login({_,_,_ ->}, {})
}