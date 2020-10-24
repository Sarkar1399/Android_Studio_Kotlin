package com.sarkardeveloper.ittest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.sarkardeveloper.ittest.modul.Data
import com.sarkardeveloper.test_5.R
import kotlinx.android.synthetic.main.fragment_test.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 * Use the [TestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestFragment : Fragment() {

    var correctAnswer = mutableListOf<String>()
    var arra: List<Data>? = null
    var ids = (0..10).random()
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var test_name: String? = null
        if (arguments != null){
            test_name = arguments?.getString("key")
        }
        if (test_name != null){
            when(test_name){
                "java" -> newJavaTest()
                "c#" -> newCsharpTest()
                "c++" -> newCplusplusTest()
                "python" -> newPythonTest()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClickNextQuestion(view)
    }

    fun onClickNextQuestion(view: View) {
        submitResultTest.setOnClickListener { view: View -> view
            .findNavController().navigate(R.id.action_testFragment_to_resultFragment)}
    }

    private fun newJavaTest() {

        //Retrofit builder
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://firebasestorage.googleapis.com/v0/")
            .build()

        val jsonPlaceholderApi = retrofit.create(JsonJavaApi::class.java)

        val myCall: Call<List<Data>> = jsonPlaceholderApi.getQuestions()

        myCall.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {

                val datum = response.body()

                arra = datum

                for (data in datum!!) {
                    correctAnswer.add(data.CorrectAnswer)
                    if (data.ID == ids) {
                        questionsText.text = data.Question
                        answerFirst.text = data.Answers1
                        answerSecond.text = data.Answers2
                        answerThree.text = data.Answers3
                        answerFour.text = data.Answers4
                    }
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }
        })
    }

    private fun newCsharpTest() {

        //Retrofit builder
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://firebasestorage.googleapis.com/v0/b/it-test-a8445.appspot.com/o/")
            .build()

        val jsonPlaceholderApi = retrofit.create(JsonCsharpApi::class.java)

        val myCall: Call<List<Data>> = jsonPlaceholderApi.getQuestions()

        myCall.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {

                val datum = response.body()

                arra = datum

                for (data in datum!!) {
                    correctAnswer.add(data.CorrectAnswer)
                    if (data.ID == ids) {
                        questionsText.text = data.Question
                        answerFirst.text = data.Answers1
                        answerSecond.text = data.Answers2
                        answerThree.text = data.Answers3
                        answerFour.text = data.Answers4
                    }
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }
        })
    }

    private fun newCplusplusTest() {

        //Retrofit builder
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://firebasestorage.googleapis.com/v0/b/it-test-a8445.appspot.com/o/")
            .build()

        val jsonPlaceholderApi = retrofit.create(JsonCplusplusApi::class.java)

        val myCall: Call<List<Data>> = jsonPlaceholderApi.getQuestions()

        myCall.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {

                val datum = response.body()

                arra = datum

                for (data in datum!!) {
                    correctAnswer.add(data.CorrectAnswer)
                    if (data.ID == ids) {
                        questionsText.text = data.Question
                        answerFirst.text = data.Answers1
                        answerSecond.text = data.Answers2
                        answerThree.text = data.Answers3
                        answerFour.text = data.Answers4
                    }
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }
        })
    }

    private fun newPythonTest() {

        //Retrofit builder
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://firebasestorage.googleapis.com/v0/b/it-test-a8445.appspot.com/o/")
            .build()

        val jsonPlaceholderApi = retrofit.create(JsonPythonApi::class.java)

        val myCall: Call<List<Data>> = jsonPlaceholderApi.getQuestions()

        myCall.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {

                val datum = response.body()

                arra = datum

                for (data in datum!!) {
                    correctAnswer.add(data.CorrectAnswer)
                    if (data.ID == ids) {
                        questionsText.text = data.Question
                        answerFirst.text = data.Answers1
                        answerSecond.text = data.Answers2
                        answerThree.text = data.Answers3
                        answerFour.text = data.Answers4
                    }
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                Log.e("ERROR", t.message.toString())
            }
        })
    }

}