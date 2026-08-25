package com.example.calculatorlatest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview


val buttonList= listOf(
    "C","(",")","/",
    "7","8","9","*",
    "4","5","6","+",
    "1","2","3","-",
    "AC","0",".","="
)
@Composable
fun Calculator(modifier: Modifier= Modifier,viewModel: CalculatorViewModel) {
    val equationText = viewModel.equationText.observeAsState("")
    val resultText = viewModel.resultText.observeAsState("")

    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = equationText.value ?: "",
                style = TextStyle(
                    fontSize = 32.sp,
                    textAlign = TextAlign.End,
                    color = Color.Black
                ),
                modifier = Modifier.fillMaxWidth(),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = resultText.value ?: "",
                style = TextStyle(
                    fontSize = 70.sp, // Made it a bit larger to match screenshot
                    textAlign = TextAlign.End,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.fillMaxWidth(),
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(10.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                items(buttonList) {
                    CalculatorButton(btn = it, onClick = {
                        viewModel.onButtonClick(it)
                    })
                }
            }
        }
    }
}
@Composable
fun CalculatorButton(btn: String, onClick: () -> Unit) {
    Box(modifier = Modifier.padding(8.dp)) {
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier.size(80.dp),
            shape = CircleShape,
            containerColor = Color(0xFFC4D7FF), // Light blue color matching screenshot
            contentColor = Color.Black,
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 4.dp)
        ) {
            Text(
                text = btn,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    Calculator(viewModel = CalculatorViewModel())
}
