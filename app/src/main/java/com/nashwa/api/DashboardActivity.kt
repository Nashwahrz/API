package com.nashwa.api

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nashwa.api.adapter.BeritaAdapter
import com.nashwa.api.api.ApiClient
import com.nashwa.api.model.BeritaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {
    private lateinit var svJudul : SearchView
    private lateinit var progressBar : ProgressBar
    private lateinit var rvBerita : RecyclerView
    private lateinit var floatBtnTambah : FloatingActionButton
    private lateinit var  beritaAdapter: BeritaAdapter
    private lateinit var imgNotFound : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        svJudul = findViewById(R.id.svJudul)
        progressBar = findViewById(R.id.progressBar)
        rvBerita = findViewById(R.id.rvBerita)
        floatBtnTambah = findViewById(R.id.floatBtnTambah)
        imgNotFound = findViewById(R.id.imgNotFound)


        //panggil method getBerita
        getBerita("")

        svJudul.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(pencarian: String?): Boolean {
               getBerita(pencarian.toString())
                return true
            }
        })



    }

    @SuppressLint("SuspiciousIndentation")
    private fun getBerita(judul: String){
      progressBar.visibility = View.VISIBLE
        ApiClient.apiService.getListBerita(judul).enqueue(object : Callback<BeritaResponse>{
            override fun onResponse(call:
                                    Call<BeritaResponse>,
                                    response: Response<BeritaResponse>)
            {
                if (response.isSuccessful){
                    if (response.body()!!.success){
                        //set dta
                        beritaAdapter = BeritaAdapter(arrayListOf())
                        rvBerita.adapter = beritaAdapter
                        beritaAdapter.setData(response.body()!!.data)
                        imgNotFound.visibility = View.GONE
                    }
                    else {
                        //jika data tidak ditemukan
                        beritaAdapter = BeritaAdapter(arrayListOf())
                        rvBerita.adapter = beritaAdapter
                        imgNotFound.visibility = View.VISIBLE

                    }
                }
                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<BeritaResponse>, t: Throwable) {
               Toast.makeText(this@DashboardActivity,"Error : ${t.message}",Toast.LENGTH_LONG)
                   .show()
                progressBar.visibility = View.GONE
            }
        })
    }
}