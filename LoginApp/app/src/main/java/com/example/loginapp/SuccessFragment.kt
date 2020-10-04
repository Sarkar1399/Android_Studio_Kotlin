package com.example.loginapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_success.*


/**
 * A simple [Fragment] subclass.
 * Use the [SuccessFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        successBtn.setOnClickListener { view: View -> view.findNavController().navigate(R.id.action_successFragment_to_headerFragment) }

        Picasso.get()
            .load("https://387b72ivq1z3mni0n261y7l1-wpengine.netdna-ssl.com/wp-content/uploads/2018/04/kotlin-1.jpg")
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(successImg)
    }
}