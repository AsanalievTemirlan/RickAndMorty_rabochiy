package com.geeks.rickandmorty.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.geeks.rickandmorty.data.apiService.ApiService
import com.geeks.rickandmorty.data.model.characters.Character
import com.geeks.rickandmorty.data.model.detailCharacter.DetailModel
import com.geeks.rickandmorty.data.paging.PagingSource
import com.geeks.rickandmorty.utils.Resource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiService) {

    fun getCharacters(): LiveData<Resource<PagingData<Character>>> {
        return liveData {
            emit(Resource.Loading())
            try {
                val pager = Pager(
                    config = PagingConfig(
                        pageSize = 10,
                        enablePlaceholders = false
                    ),
                    pagingSourceFactory = { PagingSource(api) }
                ).liveData

                emitSource(pager.map { Resource.Success(it) })

            } catch (e: Exception) {
                emit(Resource.Error("Failed to load characters: ${e.message}"))
            }
        }
    }


    fun getCharacter(id: Int): LiveData<Resource<DetailModel>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                val response = api.getSingleCharacter(id)
                if (response.isSuccessful && response.body() != null) {
                    emit(Resource.Success(response.body()!!))
                } else {
                    emit(Resource.Error("Error: ${response.message()}"))
                }
            } catch (e: Exception) {
                emit(Resource.Error("Network error: ${e.message}"))
            }
        }
    }


}