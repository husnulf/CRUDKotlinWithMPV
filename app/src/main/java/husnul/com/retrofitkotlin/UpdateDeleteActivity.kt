package husnul.com.retrofitkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import husnul.com.retrofitkotlin.MPVDeleteUpdate.PresenterModel
import husnul.com.retrofitkotlin.MPVDeleteUpdate.PresenterUpdateHapus
import kotlinx.android.synthetic.main.activity_update_delete.*
import kotlinx.android.synthetic.main.custom_list.*

class UpdateDeleteActivity : AppCompatActivity(), PresenterModel {


    //deklerasi variabel untuk nampung index
    var id: Long? = null
    var nis: Long? = null
    var nama: String? = null
    var presenter: PresenterUpdateHapus? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete)

        presenter = PresenterUpdateHapus(this)

        id = intent.getLongExtra("id", 0)
        nis = intent.getLongExtra("nis", 0)
        nama = intent.getStringExtra("nama")



        deletenama.setText(nama)
        deletenis.setText(nis.toString())

        btndelete.setOnClickListener {
            presenter?.hapus(id.toString())

        }
        btnupdate.setOnClickListener {
            presenter?.update(id.toString(), deletenama.text.toString(), deletenis.text.toString())
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

    }
}
