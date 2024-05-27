package com.geeks.rickandmorty.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.rickandmorty.ui.fragment.CharacterDetailFragment
import com.geeks.rickandmorty.R
import com.geeks.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.container, CharacterDetailFragment())
            .commit()
    }
}