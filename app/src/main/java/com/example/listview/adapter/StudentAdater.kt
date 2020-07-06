package com.example.listview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.listview.datas.Student
import kotlinx.android.synthetic.main.activity_main.view.*

class StudentAdater(val mContext: Context, val resId: Int, val mList: List<Student>) :
    ArrayAdapter<Student>(mContext, resId, mList) {
   // 화면 그려줄때 사용하는 객체
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        //받아본 임시 row가 nall인가?
        if (tempRow == null)

            tempRow = inf.inflate(R.layout.student_List_item)

        //tempRow에는 null일 가능성이 없다
        //진짜 row에는 절대 null에 아니게 된 tempRow를 복사



        val row = tempRow!!

        return row
    }


}