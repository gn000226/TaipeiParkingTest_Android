package com.example.taipeiparkingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var jsonTask = JsonTask()

    lateinit var recyclerView: RecyclerView
    var parkListAdapter : ParkListAdapter? = null
    var layoutManager : LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = layoutManager

    }

    override fun onStart() {
        super.onStart()
        val jsonString = jsonTask.getDataListFromAssets(this@MainActivity,"TCMSV_alldesc.json")
        val result = jsonString!!.replace("\n","")      // 清除json字串中的多餘字
        val gson = Gson()
        val dataModel: DataModel = gson.fromJson(result,DataModel::class.java)
        parkListAdapter = ParkListAdapter(dataModel)
        recyclerView.adapter = parkListAdapter
    }
}