package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    dosen1: List<String>,
    dosen2: List<String>,
    onSelectionChanged: (String) -> Unit,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var nama by rememberSaveable { mutableStateOf("") }
    var nim by rememberSaveable { mutableStateOf("") }
    var konsentrasi by rememberSaveable { mutableStateOf("") }
    var skripsi by remember { mutableStateOf("") }
    var dp1 by remember { mutableStateOf("") }
    var dp2 by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(nama, nim, konsentrasi, skripsi, dp1, dp2)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.judul),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)))
        OutlinedTextField(
            placeholder = { Text("Masukkan Nama") },
            value = nama,
            singleLine = true,
            onValueChange = { nama = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.nama
                    )
                )
            })
        OutlinedTextField(
            placeholder = { Text("Masukkan NIM") },
            value = nim,
            singleLine = true,
            onValueChange = { nim = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.nim
                    )
                )
            })
        OutlinedTextField(
            placeholder = { Text("Masukkan Konsentrasi") },
            value = konsentrasi,
            singleLine = true,
            onValueChange = { konsentrasi = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.konsentrasi
                    )
                )
            })
        OutlinedTextField(
            placeholder = { Text("Masukkan Judul Skripsi") },
            value = skripsi,
            singleLine = true,
            onValueChange = { skripsi = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.skripsi
                    )
                )
            })
        Row() {
            Column(
                modifier =
                Modifier.padding(dimensionResource(R.dimen.padding_medium))
            ) {
                dosen1.forEach { item ->
                    Row(modifier = Modifier.selectable(
                        selected = dp1 == item,
                        onClick = {
                            dp1 = item
                            onSelectionChanged(item)
                        }
                    ),
                        verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = dp1 == item,
                            onClick = {
                                dp1 = item
                                onSelectionChanged(item)
                            }
                        )
                        Text(item)
                    }
                }
                Column(
                    modifier =
                    Modifier.padding(dimensionResource(R.dimen.padding_medium))
                ) {
                    dosen2.forEach { item ->
                        Row(modifier = Modifier.selectable(
                            selected = dp2 == item,
                            onClick = {
                                dp2 = item
                                onSelectionChanged(item)
                            }
                        ),
                            verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(selected = dp2 == item,
                                onClick = {
                                    dp2 = item
                                    onSelectionChanged(item)
                                }
                            )
                            Text(item)
                        }
                    }
                }
                Button(
                    modifier = Modifier.weight(1f),
                    enabled = listData.isNotEmpty(),
                    onClick = onNextButtonClicked
                ) {
                    Text(stringResource(id = R.string.next))
                }
            }
        }
    }
}
