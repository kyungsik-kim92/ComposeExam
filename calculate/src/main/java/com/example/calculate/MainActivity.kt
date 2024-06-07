package com.example.calculate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculate.ui.theme.ComposeExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExamTheme {
                CalculatorScreen()
            }
        }
    }
}


@Composable
fun CalculatorScreen(viewModel: MainViewModel = viewModel()) {
    val number1 by remember {
        mutableStateOf(viewModel.number1)
    }
    val number2 by remember {
        mutableStateOf(viewModel.number2)
    }
    val result by remember {
        mutableStateOf(viewModel.result)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        Row {
            Text(text = "첫번째 값", modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                value = number1.value,
                onValueChange = { viewModel.onInput1Change(it) }
            )


        }
        Row {
            Text(text = "두번째 값", modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                value = number2.value,
                onValueChange = { viewModel.onInput2Change(it) })
        }


        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { viewModel.calculate(OperatorType.PLUS) },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "더하기", fontSize = 12.sp)
            }
            Button(
                onClick = { viewModel.calculate(OperatorType.MINUS) },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "빼기", fontSize = 12.sp)
            }
            Button(
                onClick = { viewModel.calculate(OperatorType.MULTIPLY) },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "곱하기", fontSize = 12.sp)
            }
            Button(
                onClick = { viewModel.calculate(OperatorType.DIVIDE) },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "나누기", fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "결과: ${result.value}",
            fontSize = 24.sp,
        )
    }
}