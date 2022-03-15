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
import com.example.testmobilewallet.App
import com.example.testmobilewallet.DataBase.entities.Pay
import com.example.testmobilewallet.DataBase.entities.Services
import com.example.testmobilewallet.databinding.FragmentPayBinding

class PayFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private var _binding: FragmentPayBinding? = null
    private val binding get() = _binding!!

    var categoryId: Int? = null
    var serviceId: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val dbService = App.instance?.getDatabase()?.CategoryDao()
        val dbPay = App.instance?.getDatabase()?.CategoryDao()
        val categoryName = dbCategory?.getNameCategory()
        val serviceName = dbService?.getAllServicesname()
        spinnerCategory(binding.spinnercategory, categoryName!!)
        binding.spinnercategory.onItemSelectedListener = this
        spinnerService(binding.spinnerservice, serviceName!!)
        binding.spinnerservice.onItemSelectedListener = this
        binding.savepay.setOnClickListener {
            dbPay?.addPay(Pay(
                idPay = null,
                summa = binding.editprice.text.toString().toInt()

            ))
        }
    }


    fun spinnerCategory(spinner: Spinner, list: List<String>) {
        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)
        spinner.setAdapter(adapter)
    }

    fun spinnerService(spinner: Spinner, list: List<String>) {
        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)
        spinner.setAdapter(adapter)
    }

    override fun onItemSelected(item1: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val category = App.instance?.getDatabase()?.CategoryDao()?.getAllCategory()
        for (i in category!!) {
            if (item1?.selectedItem == i.nameCategory) {
                categoryId = i.idCategory
            }
        }
        val service = App.instance?.getDatabase()?.CategoryDao()?.getAllServices()
        for (i in service!!) {
            if (item1?.selectedItem == i.serviceName) {
                serviceId = i.idServices
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
