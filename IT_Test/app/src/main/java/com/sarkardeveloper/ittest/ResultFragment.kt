package com.sarkardeveloper.ittest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.sarkardeveloper.test_5.R
import kotlinx.android.synthetic.main.fragment_result.*

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var result: Int = 0
        if (arguments != null){
            result = arguments?.getInt("result")!!
        }
        Toast.makeText(view.context, result.toString(), Toast.LENGTH_LONG).show()
        progressBar.progress = result
        progressText.text = "$result%"
//        onClickToNavFragment(view)

        tryAgain.setOnClickListener {
            tryAgain.setOnClickListener { view: View -> view
                .findNavController().navigate(R.id.action_resultFragment_to_navFragment)}
        }

    }

}