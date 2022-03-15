package com.example.testmobilewallet.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.navigation.fragment.findNavController
import com.example.testmobilewallet.App
import com.example.testmobilewallet.DataBase.entities.Category
import com.example.testmobilewallet.R
import com.example.testmobilewallet.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    val idCategory: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = App.instance?.getDatabase()?.CategoryDao()


        binding.savecategory.setOnClickListener {
            db?.addCategory(
                Category(
                    idCategory = null,
                    nameCategory = binding.editCategory.text.toString()
                ))



        }
        binding.addservice.setOnClickListener {
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToAddServiceFragment())
        }
        
    }



}


