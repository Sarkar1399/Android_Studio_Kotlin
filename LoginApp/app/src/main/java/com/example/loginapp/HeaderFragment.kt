package com.example.loginapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_header.*
import kotlinx.android.synthetic.main.fragment_success.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * A simple [Fragment] subclass.
 * Use the [HeaderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HeaderFragment : Fragment() {

    private var login: String? = null
    private var password: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_header, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postButton.setOnClickListener {
            login = emailText.text.toString()
            password = passwordText.text.toString()

            if (login?.isEmpty()!! || password?.isEmpty()!!) {

                Toast.makeText(context, "Логин или пароль не были указаны!", Toast.LENGTH_SHORT).show()

            } else {
                val thisUser = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://tajik.dev/p/android/api/").build()

                val jsonUser =  thisUser.create(LoginPassword::class.java)
                val allUsers: Call<Authorization>? = jsonUser.getLoginAndPassword(login!!, password!!)

                allUsers?.enqueue(object : Callback<Authorization> {
                    @SuppressLint("SetTextI18n")
                    override fun onResponse(
                        call: Call<Authorization>,
                        response: Response<Authorization>
                    ) {
                        val jasonApi = response.body()

                        if (jasonApi?.userID == 0){
                            Toast.makeText(context, "Такого пользователья не сушествует!", Toast.LENGTH_SHORT).show()
                        } else {
                            view.findNavController().navigate(R.id.action_headerFragment_to_successFragment)
                        }
                    }

                    override fun onFailure(call: Call<Authorization>, t: Throwable) {
                        Toast.makeText(context, "Проверте ваш интернет соединение!", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }

}

class Authorization {
    @SerializedName("userid")
    @Expose
    var userID: Int = 0
}

interface LoginPassword{
    @FormUrlEncoded
    @POST("https://tajik.dev/p/android/api/")
    fun getLoginAndPassword(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<Authorization>?

}