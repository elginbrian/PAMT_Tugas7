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
fun daftar(onSimpan: (nim: String, nama: String, email: String, alamat: String) -> Unit) {
    val nimState = remember { mutableStateOf("") }
    val namaState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val alamatState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(text = "DAFTAR")

        OutlinedTextField(
            value = nimState.value,
            onValueChange = { nimState.value = it },
            label = { Text("NIM") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = namaState.value,
            onValueChange = { namaState.value = it },
            label = { Text("NAMA") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("EMAIL") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = alamatState.value,
            onValueChange = { alamatState.value = it },
            label = { Text("ALAMAT") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 12.dp),
            onClick = { onSimpan(nimState.value, namaState.value, emailState.value, alamatState.value) }
        ) {
            Text("SIMPAN")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun daftarPreview() {
    daftar { _, _, _, _ -> }
}