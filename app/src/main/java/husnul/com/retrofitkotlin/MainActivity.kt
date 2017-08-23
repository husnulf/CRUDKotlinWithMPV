package husnul.com.retrofitkotlin

import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import husnul.com.retrofitkotlin.MPVDeleteUpdate.PrentrTampil
import husnul.com.retrofitkotlin.MPVDeleteUpdate.PresenterTampil
import kotlinx.android.synthetic.main.custom_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), PrentrTampil {

    //inisialisasi dibuat global
    var presenterTam : PresenterTampil? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenterTam = PresenterTampil(this)
        //tmapilin data
//        dapatData()
        presenterTam!!.dataTampil()
        img.setOnClickListener {
            startActivity(Intent(applicationContext, TambahActivity::class.java))
        }
    }

    override fun result(result: List<Datum>) {
        var adapter = Custom(this@MainActivity, result)
        var linear = LinearLayoutManager(applicationContext)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = linear
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Error(error: String) {

//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}


