package com.example.expandrecyclerview

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberItem(
    isExpanded: Boolean,
    item: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = item.toString(), fontSize = 50.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        if (isExpanded) {
            Text(
                text = "눌림", fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun NumberList() {
    val dataList = SnapshotStateList<Boolean>().apply {
        repeat(101) { add(false) }
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(dataList.size) { index ->
    Log.d("오류","${dataList[0]}")
            NumberItem(isExpanded = dataList[index], item = index, onClick = {
                dataList[index] =! dataList[index]
            })

        }
    }
}

