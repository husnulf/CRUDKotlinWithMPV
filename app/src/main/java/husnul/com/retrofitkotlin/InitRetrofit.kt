package husnul.com.retrofitkotlin

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by Husnul on 22/08/2017.
 */
class InitRetrofit {

    //fun untuk inisialisasi retrofit
    fun getInitRetrofit(): Retrofit {

        return Retrofit
                .Builder()
                .baseUrl("http://192.168.20.159/lumen-api24/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getInitInstance(): ApiService {
        return getInitRetrofit().create(ApiService::class.java)
    }

}

interface ApiService {

    //kalau post pakai @Field
    @GET("input-siswa")
    fun request_insert(
            @Query("nama") name: String,
            @Query("nis") nis: String,
            @Query("status") status: Int

    ): Call<ResponseInsert>

    @GET("get-siswa")
    fun request_getdata(

    ): Call<ResponData>

    @FormUrlEncoded
    @POST("update-siswa")
    fun request_update(
            @Field("id") id: String,
            @Field("nama") name: String,
            @Field("nis") nis: String
    ): Call<ResponseInsert>


    @FormUrlEncoded
    @POST("delete-siswa")
    fun request_delete(
            @Field("id") id: String
    ): Call<ResponseInsert>


}