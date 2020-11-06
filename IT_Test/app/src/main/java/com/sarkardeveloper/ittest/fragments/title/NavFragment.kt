package com.sarkardeveloper.ittest.fragments.title

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.sarkardeveloper.test_5.R
import kotlinx.android.synthetic.main.fragment_nav.*

//@Suppress("DEPRECATION")
class NavFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.nav_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI
            .onNavDestinationSelected(item, requireView()
                .findNavController())||super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newJavaTest(view)
        newCsharpTest(view)
        newCplusplusTest(view)
        newPythonTest(view)
    }

    private fun newJavaTest(view: View) {
        val test_name = Bundle()
        test_name.putString("key", "Java")

//        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
//
//        val isConnected = activeNetwork?.isConnectedOrConnecting == true

            layoutJavaCard.setOnClickListener {
                view.findNavController()
                    .navigate(R.id.action_navFragment_to_testFragment, test_name) }
    }
    private fun newCsharpTest(view: View) {
        val test_name = Bundle()
        test_name.putString("key", "C#")

//        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
//
//        val isConnected = activeNetwork?.isConnectedOrConnecting == true

            layoutCsharpCard.setOnClickListener {
                view.findNavController()
                    .navigate(R.id.action_navFragment_to_testFragment, test_name) }
    }

    private fun newCplusplusTest(view: View) {
        val test_name = Bundle()
        test_name.putString("key", "C++")
//
//        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
//
//        val isConnected = activeNetwork?.isConnectedOrConnecting == true

            layoutCplusplusCard.setOnClickListener {
                view.findNavController()
                    .navigate(R.id.action_navFragment_to_testFragment, test_name) }

    }
    private fun newPythonTest(view: View) {
        val test_name = Bundle()
        test_name.putString("key", "Python")

//        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
//
//        val isConnected = activeNetwork?.isConnectedOrConnecting == true

            layoutPythonCard.setOnClickListener {
                view.findNavController()
                    .navigate(R.id.action_navFragment_to_testFragment, test_name) }

    }
}