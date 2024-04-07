package com.example.imageapplication

import android.net.DnsResolver.Callback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class SecondActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerImageAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var modelClassArrayList: ArrayList<ApiModel>
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var backup: ArrayList<ApiModel>
    private lateinit var jsonPlaceholderService: JsonPlaceholderService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        recyclerView = findViewById(R.id.recyclerView)
        modelClassArrayList = ArrayList()
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        backup = ArrayList()
        adapter = RecyclerImageAdapter(this, modelClassArrayList)
        recyclerView.adapter = adapter

       getMyData()

    }
    private fun getMyData(){
        ImageInstance.ImageInstance.getInstance().getApi().getPhotos().enqueue(object : retrofit2.Callback<List<ApiModel>?> {
            override fun onResponse(
                call: Call<List<ApiModel>?>,
                response: Response<List<ApiModel>?>
            ) {
                if (response.isSuccessful) {
                    val photos = response.body()
                    photos?.let {
                        modelClassArrayList.addAll(it)
                        adapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<List<ApiModel>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}
