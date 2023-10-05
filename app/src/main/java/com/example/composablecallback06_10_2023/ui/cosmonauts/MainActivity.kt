package com.example.composablecallback06_10_2023.ui.cosmonauts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composablecallback06_10_2023.ui.theme.ComposableCallback06_10_2023Theme
import com.example.model.response.CosmonautsListResponse
import com.example.model.response.CosmonautsResponse
import kotlin.properties.Delegates

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CosmonautsListScreen()
        }
    }
}
@Composable
fun CosmonautsListScreen() {
    val viewModel: CosmonautsListViewModel = viewModel()
    val rememberedCosmonauts: MutableState<List<CosmonautsResponse>> = remember {
        mutableStateOf(emptyList<CosmonautsResponse>())
    }
    var number: Int = 0
    viewModel.getCosmonauts {
        response ->
        val namesFromTheApi = response?.people
        rememberedCosmonauts.value = namesFromTheApi.orEmpty()
        /*val numberFromTheApi = response?.number
        if (numberFromTheApi != null) {
            number = numberFromTheApi
        }*/
        number = response?.number!!
    }
        LazyColumn{
            items(rememberedCosmonauts.value){
                    name ->
                Text(name.name)
                Text(name.craft)
                //Text(text = number.toString())
            }
        }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposableCallback06_10_2023Theme {
        Greeting("Android")
    }
}