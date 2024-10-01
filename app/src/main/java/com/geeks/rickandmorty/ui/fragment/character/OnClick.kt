package com.geeks.rickandmorty.ui.fragment.character

import com.geeks.rickandmorty.data.model.characters.Character

interface OnClick {
    fun onClick(model: Character)
}