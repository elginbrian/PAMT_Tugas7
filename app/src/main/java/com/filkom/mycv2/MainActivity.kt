package com.filkom.mycv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.filkom.mycv2.screen.Login
import com.filkom.mycv2.screen.daftar
import com.filkom.mycv2.screen.detail
import com.filkom.mycv2.ui.theme.MyCV2Theme
import java.net.URLEncoder
import java.net.URLDecoder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCV2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation()
                    }
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            Login(onLogin = { nim, nama, email ->
                val route = "detail?nim=${URLEncoder.encode(nim, "UTF-8")}" +
                        "&nama=${URLEncoder.encode(nama, "UTF-8")}" +
                        "&email=${URLEncoder.encode(email, "UTF-8")}" +
                        "&alamat=${URLEncoder.encode("", "UTF-8")}"
                navController.navigate(route)
            }, onDaftar = {
                navController.navigate("daftar")
            })
        }

        composable("daftar") {
            daftar(onSimpan = { nim: String, nama: String, email: String, alamat: String ->
                val route = "detail?nim=${URLEncoder.encode(nim, "UTF-8")}" +
                        "&nama=${URLEncoder.encode(nama, "UTF-8")}" +
                        "&email=${URLEncoder.encode(email, "UTF-8")}" +
                        "&alamat=${URLEncoder.encode(alamat, "UTF-8")}"
                navController.navigate(route)
            })
        }

        composable(
            route = "detail?nim={nim}&nama={nama}&email={email}&alamat={alamat}",
            arguments = listOf()
        ) { backStackEntry ->
            val args = backStackEntry.arguments
            val rawNim = args?.getString("nim") ?: ""
            val rawNama = args?.getString("nama") ?: ""
            val rawEmail = args?.getString("email") ?: ""
            val rawAlamat = args?.getString("alamat") ?: ""

            val nim = try { URLDecoder.decode(rawNim, "UTF-8") } catch (e: Exception) { rawNim }
            val nama = try { URLDecoder.decode(rawNama, "UTF-8") } catch (e: Exception) { rawNama }
            val email = try { URLDecoder.decode(rawEmail, "UTF-8") } catch (e: Exception) { rawEmail }
            val alamat = try { URLDecoder.decode(rawAlamat, "UTF-8") } catch (e: Exception) { rawAlamat }

            detail(nim, nama, email, alamat, onDaftar = {
                navController.navigate("daftar")
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    MyCV2Theme {
        AppNavigation()
    }
}