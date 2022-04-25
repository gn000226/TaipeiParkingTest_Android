package com.example.taipeiparkingtest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataModel {

    @SerializedName("data")
    var data : ParkListModel? = null

    inner class ParkListModel {
        @SerializedName("UPDATETIME")
        var time : String = ""

        @SerializedName("park")
        var park : MutableList<ParkModel>? = null
    }

    inner class ParkModel {

        @SerializedName("name")
        var name : String = ""

        @SerializedName("tel")
        var tel : String = ""

        @SerializedName("address")
        var address : String = ""
    }
}
