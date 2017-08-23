package husnul.com.retrofitkotlin.MPVDeleteUpdate

import android.util.Log
import husnul.com.retrofitkotlin.InitRetrofit
import husnul.com.retrofitkotlin.ResponseInsert
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Husnul on 23/08/2017.
 */
class PresenterUpdateHapus {

    var presenterView: PresenterModel? = null

    constructor(presenterView: PresenterModel?) {
        this.presenterView = presenterView
    }

    fun hapus(id: String) {
        var getInit = InitRetrofit().getInitInstance()
        //getRequest
        var request = getInit.request_delete(id)

        request.enqueue(object : Callback<ResponseInsert> {
            override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
                Log.d("Error Insert", t.toString())
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
//                        progress.dismiss()
                Log.d("Error Insert", response?.message())
                if (response != null) {
                    if (response.isSuccessful && response.body()?.status.equals("true")) {
                        var result = response.body()?.status
                        var msg = response.body()?.msg
                        presenterView?.result(result!!, msg!!)
                    }
                }
            }
        })
    }
    fun update (id : String,nama : String,nis : String){
        var getInit = InitRetrofit().getInitInstance()
        //getRequest
        var request = getInit.request_update(id,nama,nis)

        request.enqueue(object : Callback<ResponseInsert> {
            override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
                Log.d("Error Insert", t.toString())
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
//                        progress.dismiss()
                Log.d("Error Insert", response?.message())
                if (response != null) {
                    if (response.isSuccessful && response.body()?.status.equals("true")) {
                        var result = response.body()?.status
                        var msg = response.body()?.msg
                        presenterView?.result(result!!, msg!!)
                    }
                }
            }
        })
    }
    fun tambah (nama: String,nis: String,status: Int){
        var getInit = InitRetrofit().getInitInstance()
        //getRequest
        var request = getInit.request_insert(nama, nis ,status)
        //get Request
//                var progress = ProgressDialog(applicationContext)
//                progress.setMessage("Santai Donk")
//                progress.show()

        request.enqueue(object : Callback<ResponseInsert> {

            override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
//                        progress.dismiss()
                Log.d("Error Insert", t.toString())
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
//                        progress.dismiss()
                Log.d("Error Insert", response?.message())
                if (response != null) {
                    if (response.isSuccessful && response.body()?.status.equals("true")) {
                        var result = response.body()?.status
                        var msg = response.body()?.msg
                        presenterView?.result(result!!, msg!!)
                       }

                }
            }

        })
    }
}
