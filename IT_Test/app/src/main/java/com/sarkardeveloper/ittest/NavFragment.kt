package com.sarkardeveloper.ittest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.sarkardeveloper.test_5.R
import kotlinx.android.synthetic.main.fragment_nav.*

/**
 * A simple [Fragment] subclass.
 * Use the [NavFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NavFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newJavaTest(view)
        newCsharpTest(view)
        newCplusplusTest(view)
        newPythonTest(view)
    }

    fun newJavaTest(view: View) {
        val test_name = Bundle()
        test_name.putString("key", "java")

        layoutJavaCard.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_navFragment_to_testFragment, test_name) }
    }
    fun newCsharpTest(view: View) {
        val test_name = Bundle()
        test_name.putString("key", "c#")

        layoutCsharpCard.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_navFragment_to_testFragment, test_name) }
    }
    fun newCplusplusTest(view: View) {
        val test_name = Bundle()
        test_name.putString("key", "c++")

        layoutCplusplusCard.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_navFragment_to_testFragment, test_name) }
    }
    fun newPythonTest(view: View) {
        val test_name = Bundle()
        test_name.putString("key", "python")

        layoutPythonCard.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_navFragment_to_testFragment, test_name) }
    }
}