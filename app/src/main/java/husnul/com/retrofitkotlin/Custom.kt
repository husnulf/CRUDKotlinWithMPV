package husnul.com.retrofitkotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Husnul on 23/08/2017.
 */
class Custom : RecyclerView.Adapter<Custom.MyHolder>{

    var c: Activity? = null
    var data2: List<Datum>? = null

    constructor(arg: MainActivity, data: List<Datum>?) {
        this.c = arg
        this.data2 = data
    }




    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        holder?.txtnama?.text = data2?.get(position)!!.nama
        holder?.txtnis?.text = data2?.get(position)!!.nis.toString()
        holder?.txtganti?.setOnClickListener {
            var pindah = Intent(c,UpdateDeleteActivity::class.java)
                pindah.putExtra("id", data2!!.get(position).id)
                pindah.putExtra("nama", data2!!.get(position).nama)
                pindah.putExtra("nis", data2!!.get(position).nis)
                c?.startActivity(pindah)

        }

//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return data2!!.size
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        var view = LayoutInflater.from(c).inflate(R.layout.custom_list,parent,false)
        return MyHolder(view)
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var txtnama : TextView? = itemView?.findViewById(R.id.listname) as TextView?
        var txtnis : TextView? = itemView?.findViewById(R.id.listnis) as TextView?
//        var txtupdate : TextView? = itemView?.findViewById(R.id.linkupdate) as TextView?
        var txtganti : TextView? = itemView?.findViewById(R.id.linkupdate) as TextView?


    }


}