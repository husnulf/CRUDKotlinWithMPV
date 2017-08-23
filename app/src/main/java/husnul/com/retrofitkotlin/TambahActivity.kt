package husnul.com.retrofitkotlin

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import husnul.com.retrofitkotlin.MPVDeleteUpdate.PresenterModel
import husnul.com.retrofitkotlin.MPVDeleteUpdate.PresenterUpdateHapus
import kotlinx.android.synthetic.main.activity_tambah.*
import kotlinx.android.synthetic.main.activity_update_delete.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahActivity : AppCompatActivity(), PresenterModel {


    var presenter: PresenterUpdateHapus? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)
        presenter = PresenterUpdateHapus(this)

        btnsubmit.setOnClickListener {
            presenter?.tambah(edtnama.text.toString(),edtnis.text.toString(),status = 0)
        }
    }
    override fun result(result: String, msg: String) {
        if (result.equals("true")) {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
        }
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Error(error: String) {
        Log.d("Error delete", error.toString())
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
