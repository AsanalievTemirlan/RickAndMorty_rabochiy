package com.geeks.rickandmorty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import com.geeks.rickandmorty.ui.adpter.CustomExpandableListAdapter
import com.geeks.rickandmorty.model.Episode
import com.geeks.rickandmorty.databinding.FragmentCharacterDatailBinding

class CharacterDetailFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDatailBinding
    private lateinit var expandableListView: ExpandableListView
    private lateinit var expandableListAdapter: CustomExpandableListAdapter
    private lateinit var listGroup: List<String>
    private lateinit var listItem: HashMap<String, List<Episode>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDatailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expandableListView = binding.expandableListView
        initListData()
        expandableListAdapter = CustomExpandableListAdapter(requireContext(), listGroup, listItem)
        expandableListView.setAdapter(expandableListAdapter)
    }

    private fun initListData() {
        listGroup = listOf("Season 1","Season 2")

        val episodeList = listOf(
            Episode("Pilot", "December 13, 2013"),
            Episode("Episode 2", "December 20, 2013")
        )

        listItem = hashMapOf(listGroup[0] to episodeList)
    }
}