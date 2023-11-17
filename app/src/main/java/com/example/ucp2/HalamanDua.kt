package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.ucp2.data.OrderUIState

@Composable
fun HalamanDua(
    orderUiState: OrderUIState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val items = listOf(
        Pair(stringResource(R.string.nama), orderUiState.nama),
        Pair(stringResource(R.string.nim), orderUiState.nim),
        Pair(stringResource(R.string.konsentrasi), orderUiState.konsentrasi),
        Pair(stringResource(R.string.skripsi), orderUiState.skripsi),
        Pair(stringResource(R.string.dp1), orderUiState.dp1),
        Pair(stringResource(R.string.dp2), orderUiState.dp2)
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            items.forEach{item->
                Column{
                    Text(item.first.uppercase(), fontWeight = FontWeight.Bold)
                    Text(text = item.second.toString())
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            Row(
                modifier = Modifier
                    .weight(1f, false)
                    .padding(dimensionResource(R.dimen.padding_small))
            ){
                Column (verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))){
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {}
                    ){
                        Text(stringResource(R.string.submit))
                    }
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = onCancelButtonClicked
                    ) {
                        Text(stringResource(R.string.back))
                    }
                }
            }
        }
    }

}