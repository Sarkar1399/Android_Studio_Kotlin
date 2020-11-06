package com.sarkardeveloper.ittest.fragments.result

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.sarkardeveloper.ittest.modul.ProgressDb
import com.sarkardeveloper.ittest.viewmodel.ProgressViewModel
import com.sarkardeveloper.test_5.R
import kotlinx.android.synthetic.main.fragment_result.*
import kotlinx.android.synthetic.main.fragment_result.view.*

class ResultFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var mProgressViewModel: ProgressViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_result, container, false)

        mProgressViewModel = ViewModelProvider(this).get(ProgressViewModel::class.java)

        view.tryAgain.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {

        var result = 0
        var tests = ""
        if (arguments != null){
            result = arguments?.getInt("result")!!
            tests = arguments?.getString("tests")!!
        }

        val nameTest = "$tests"
        val textTest = "$result%"
        val testProgress = progressBar.progress.toString()
        if (inputCheck(testProgress)){

            val result = ProgressDb(0, nameTest, textTest, testProgress)

            mProgressViewModel.addTest(result)
        }else{
            Toast.makeText(requireContext(), "Pleas see ERROR no ADD!!!", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(testProgress: String): Boolean {
        return !(TextUtils.isEmpty(testProgress))
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var result = 0
        var tests = ""
        if (arguments != null){
            result = arguments?.getInt("result")!!
            tests = arguments?.getString("tests")!!
        }
        Toast.makeText(view.context, result.toString(), Toast.LENGTH_LONG).show()
        progressBar.progress = result
        progressText.text = "$result%"

        tryAgain.setOnClickListener {
            insertDataToDatabase()
            tryAgain.setOnClickListener { view: View -> view
                .findNavController().navigate(R.id.action_resultFragment_to_navFragment)}
        }

    }

}