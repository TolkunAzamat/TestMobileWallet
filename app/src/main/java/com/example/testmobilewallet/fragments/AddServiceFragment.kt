package com.example.testmobilewallet.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.testmobilewallet.App
import com.example.testmobilewallet.DataBase.entities.Services
import com.example.testmobilewallet.R
import com.example.testmobilewallet.databinding.FragmentAddServiceBinding

class AddServiceFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private var _binding: FragmentAddServiceBinding? = null
    private val binding get() = _binding!!
    var categoryId: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddServiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val dbService = App.instance?.getDatabase()?.CategoryDao()
        val categoryName = dbCategory?.getNameCategory()
        spinnerCategory(binding.listofcategory, categoryName!!)
        binding.listofcategory.onItemSelectedListener = this

        binding.saveservice.setOnClickListener {
            dbService?.addServices(Services(
                idServices = null,
                serviceName = binding.editService.text.toString(),
                categoryId=categoryId
            ))
        }
binding.imgbtn.setOnClickListener {
    findNavController()
        .navigate(AddServiceFragmentDirections.actionAddServiceFragmentToAddFragment())
}
    }

        fun spinnerCategory(spinner: Spinner, list: List<String>){
            val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)
            spinner.setAdapter(adapter)
        }

        override fun onItemSelected(item: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val category = App.instance?.getDatabase()?.CategoryDao()?.getAllCategory()
            for (i in category!!){
                if (item?.selectedItem == i.nameCategory){
                    categoryId = i.idCategory
                }
            }
        }

       override fun onNothingSelected(item: AdapterView<*>?) {
        }

}