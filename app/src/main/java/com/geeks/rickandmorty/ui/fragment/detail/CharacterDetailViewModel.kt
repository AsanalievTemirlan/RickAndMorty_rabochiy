package com.geeks.rickandmorty.ui.fragment.detail

import androidx.lifecycle.ViewModel
import com.geeks.rickandmorty.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(private val repository: Repository): ViewModel(){

    fun getCharacter(id: Int) = repository.getCharacter(id)
}