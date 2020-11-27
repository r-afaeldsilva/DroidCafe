package com.example.droidcaf

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    val serviceRetrofit = RetrofitService()
    serviceRetrofit.api?.getSobremesa()?.enqueue(object : Callback<List<Sobremesa>> {
        override fun onResponse(call: Call<List<Sobremesa>?>?, response: Response<List<Sobremesa>?>?) {
            val listaDeSobremesa = response?.body()


            descricao01.text = listaDeSobremesa?.get(0)?.descricao
            descricao02.text = listaDeSobremesa?.get(1)?.descricao
            descricao03.text = listaDeSobremesa?.get(2)?.descricao

            valor01.text = listaDeSobremesa?.get(0)?.valor
            valor02.text = listaDeSobremesa?.get(1)?.valor
            valor03.text = listaDeSobremesa?.get(2)?.valor

            Picasso.get().load(R.drawable.donut_circle).transform(CircleTransform()).into(imageView1)
            Picasso.get().load(R.drawable.icecream_circle).transform(CircleTransform()).into(imageView2)
            Picasso.get().load(R.drawable.froyo_circle).transform(CircleTransform()).into(imageView3)


        }

        override fun onFailure(call: Call<List<Sobremesa>?>?, t: Throwable?) {
            Log.e("Erro", "************** erro **********\n" + t?.message.toString())
        }
    })

    }
}