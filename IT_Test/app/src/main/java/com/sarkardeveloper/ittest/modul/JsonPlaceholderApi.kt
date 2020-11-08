package com.sarkardeveloper.ittest.modul

import com.sarkardeveloper.ittest.modul.Data
import retrofit2.Call
import retrofit2.http.GET

interface JsonJavaApi {
    @GET("b/it-test-a8445.appspot.com/o/java.json?alt=media&token=fda24946-76af-49c3-81f6-e1e6a778ff8d")
    fun getQuestions(): Call<List<Data>>
}

interface JsonCsharpApi {
    @GET("csharp.json?alt=media&token=7f758217-3bf9-43e2-beab-e3d354a3132c")
    fun getQuestions(): Call<List<Data>>
}

interface JsonCplusplusApi {
    @GET("cpp.json?alt=media&token=43c35f42-4f36-4dae-b361-a153b78e2dc3")
    fun getQuestions(): Call<List<Data>>
}

interface JsonPythonApi {
    @GET("python.json?alt=media&token=af307b77-5473-484a-83eb-228d39bfe7b5")
    fun getQuestions(): Call<List<Data>>
}
