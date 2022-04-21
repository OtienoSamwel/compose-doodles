package com.os.compose_doodles.ui.presentation.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.os.compose_doodles.data.remote.NetworkService
import com.os.compose_doodles.data.remote.model.Data
import com.os.compose_doodles.data.remote.model.PassengerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


class PagingViewModel : ViewModel() {

    private val pager = Pager(PagingConfig(pageSize = 10, enablePlaceholders = true, maxSize = 200)) {
        PassengerPagingSource()
    }
    val passengerData: Flow<PagingData<Data>> = pager.flow.cachedIn(viewModelScope)
}

class PassengerPagingSource : PagingSource<Int, Data>() {
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {

        val pageNumber = params.key ?: 0
        val response: PassengerResponse = withContext(Dispatchers.IO){NetworkService.getPassengers(pageNumber)}
        val prevKey = if (pageNumber > 0) pageNumber - 1 else null
        val nextKey = if (response.data.isNotEmpty()) pageNumber + 1 else null

        return LoadResult.Page(
            data = response.data,
            prevKey = prevKey,
            nextKey = nextKey
        )
    }
}