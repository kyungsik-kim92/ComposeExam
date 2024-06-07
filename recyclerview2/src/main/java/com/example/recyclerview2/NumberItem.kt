package com.example.recyclerview2

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NumberItem(
    item: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = item.toString(), fontSize = 50.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun NumberList() {
    val context = LocalContext.current
    val dataList = (0..100).toList()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(dataList) { number ->
            NumberItem(item = number, onClick = {
                Toast.makeText(context, "$number 번 눌렸습니다.", Toast.LENGTH_SHORT).show()
            })

        }
    }
}

