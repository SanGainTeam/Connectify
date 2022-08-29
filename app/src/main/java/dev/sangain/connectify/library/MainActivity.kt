package dev.sangain.connectify.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
/*
import dev.sangain.connectify.model.Status
*/
import dev.sangain.connectify.library.ui.theme.ConnectifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ConnectifyTheme {
/*
                val connectivityStatus by  SanGainConnectify.observer.collectAsState(initial = Status.Unavailable)
*/
                // A surface container using the 'background' color from the theme

                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//                    Text(text="Connection status is $connectivityStatus")


                }


            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello from  $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ConnectifyTheme {
        Greeting("Android")
    }
}