package husnul.com.retrofitkotlin.MPVDeleteUpdate

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import husnul.com.retrofitkotlin.Custom
import husnul.com.retrofitkotlin.InitRetrofit
import husnul.com.retrofitkotlin.ResponData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Husnul on 23/08/2017.
 */
class PresenterTampil {

    //inisialisasi presenTampil
    var presenTampil: PrentrTampil? = null

    constructor(presenTampil: PrentrTampil?) {
        this.presenTampil = presenTampil
    }

    fun dataTampil() {
        
        var api = InitRetrofit().getInitInstance()
        var call = api.request_getdata()
        call.enqueue(object : Callback<ResponData> {
            override fun onResponse(call: Call<ResponData>?, response: Response<ResponData>?) {
                Log.d("Error get data :", response?.message())
                if (response != null) {
                    if (response.isSuccessful) {
                        //get json from data json
                        var data = response.body()?.data
                        presenTampil?.result(data!!)
                        //array pindahkan ke recyclerView


                    }
                }
            }

            override fun onFailure(call: Call<ResponData>?, t: Throwable?) {
                Log.d("Error get data :", t.toString())

            }

        })

//        var adapter = Custom(this@MainActivity, data = null)

    }
}