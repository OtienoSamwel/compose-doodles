package com.os.compose_doodles.ui.presentation.paging

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import com.os.compose_doodles.data.remote.model.Data

@androidx.compose.runtime.Composable
fun PagingContent() {
    val viewModel: PagingViewModel = viewModel()
    val lazyPagingItems = viewModel.passengerData.collectAsLazyPagingItems()

    LazyColumn {
        items(lazyPagingItems) { item ->
            item?.let {
                PassengerItem(item = item)
            }
        }
        if (lazyPagingItems.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }

    }
}

@Composable
fun PassengerItem(item: Data) {
    Card(modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()) {

        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = item.airline.first().logo,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Name : ${item.name}, trips : ${item.trips}, country : ${item.airline.first().country}",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}