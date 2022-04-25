package com.example.taipeiparkingtest

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.IOException

class JsonTask {

    /* 取得json資料 */
    fun getDataListFromAssets(context: Context, fileName : String) : String? {
        val jsonObject : String?
        try {
            jsonObject = context.assets.open(fileName).bufferedReader().use {
                it.readText()
            }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonObject
    }

}