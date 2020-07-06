package com.example.listview.datas

import java.net.Inet4Address
import java.time.Year
import java.util.*

class Student(val name:String, val address:String, val birthYear: Int){

    fun getKoreanAge() : Int  {

        //킬때 마다 실제 나이가 계산되게
        val now = Calendar.getInstance()


        return now.get(Calendar.YEAR) - this.birthYear + 1
    }


}