package com.example.bmiviewmodel

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmiviewmodel.ui.theme.BmiViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiViewModelTheme {
                   BodyMassIndexApp()

            }
        }
    }
}

@Composable
fun BodyMassIndexApp(viewModel: BMIViewModel = viewModel() ){
    val reusableModifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = reusableModifier
    ){
        // Displaying the title text
        Text(
            text = stringResource(R.string.BMIViewModel_title),
            fontSize = 24.sp, // setting the font size
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = reusableModifier
        )
        // Text field for entering the height
        OutlinedTextField(
            value = viewModel.heightInput,
            onValueChange = { viewModel.changeHeightInput(it)},
            label = { Text(text = stringResource(R.string.BMIViewModel_height))},
            modifier = reusableModifier
        )
        // Text field for entering the weight
        OutlinedTextField(
            value = viewModel.weightInput,
            onValueChange = { viewModel.changeWeightInput(it)},
            label = { Text(text = stringResource(R.string.BMIViewModel_weight))},
            modifier = reusableModifier
        )

        // Displaying the result
        Text(text = stringResource(R.string.BMIViewModel_result, String.format("%.2f", viewModel.result())).replace(',', '.')
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BmiViewModelTheme {
        BodyMassIndexApp()
    }
}