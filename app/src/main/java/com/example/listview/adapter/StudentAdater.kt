package com.example.listview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listview.R
import com.example.listview.datas.Student

class StudentAdater(val mContext: Context, val resId: Int, val mList: List<Student>) :
    ArrayAdapter<Student>(mContext, resId, mList) {
   // 화면 그려줄때 사용하는 객체
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        //받아본 임시 row가 nall인가?
        if (tempRow == null)

            tempRow = inf.inflate(R.layout.student_list_item, null)

        //tempRow에는 null일 가능성이 없다
        //진짜 row에는 절대 null에 아니게 된 tempRow를 복사



        val row = tempRow!!

        //row의 내용을 실제에 맞게 변경

        //(그려줄 위치에 맞는) 실제 데이터를 가져오고
        val data = mList[position]

        // 실제 데이터를 가져오고

        //row의 컴포넌트들을 가져와서
        val nameTxt = row.findViewById<TextView>(R .id.nameTxt)
        val addressTxt = row.findViewById<TextView>(R .id.addressTxt)
        val ageTxt = row.findViewById<TextView>(R .id.ageTxt)

        //데이터 반영

        nameTxt.text = data.name
        addressTxt.text = data.address

        ageTxt.text = "${data.birthYear}세"
        //ListView에 이 row를 뿌려달라고 결과로 지정
        return row
    }


}