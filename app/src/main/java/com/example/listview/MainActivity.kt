package com.example.listview

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.listview.adapter.StudentAdater
import com.example.listview.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()

    lateinit var mAdater : StudentAdater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //미뤄둔 어댑터 객체화 실행
        mAdater = StudentAdater(this,R.layout.student_list_item,mStudentList)

        //완성된 어댑터를 리스트뷰와 연결
        studentListView.adapter = mAdater

        //어댑터를 먼저 연결하고, 내용물 추가
        mStudentList.add(Student("박호준","인천시 부평구",1990))
        mStudentList.add(Student("조경진","서울시 중량구",1988))
        mStudentList.add(Student("김재영","서울시 은평구",1986))
        mStudentList.add(Student("이에원","서울시 금천구",1984))
        mStudentList.add(Student("조장우","서울시 종로구",1983))
        mStudentList.add(Student("채정실","서울시 용산구",1991))
        mStudentList.add(Student("김미희","서울시 중량구",1995))

        //어댑터에게 새로고침 시키기

        mAdater.notifyDataSetChanged()
        //학생 목록 리스트뷰의 이벤트 처리
        studentListView.setOnItemClickListener { parent, view, position, id ->

            //각 줄을 누르면 "눌린 사람의 이름" 토스트로

            //눌린 사람이 누군지 (위에서부터 0번임)
            val clickedUser = mStudentList[position]

            //
            Toast.makeText(this, clickedUser.name, Toast.LENGTH_LONG).show()

        }

        //학생 목록 롱클릭 이벤트 처리
        studentListView.setOnItemLongClickListener { parent, view, position, id ->

            //정말 그사람을 지울지 확인. => 확인ok여야 삭제
            val deletAlert = AlertDialog.Builder(this)
            deletAlert.setTitle("학생 목록 삭제")
            deletAlert.setMessage("정말 이 학생을 삭제라시겠습니까?")
            deletAlert.setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->
                //확인을 누르면 실제로 삭제 처리

                // 오래눌린 사람을 명단에서 삭제
                mStudentList.removeAt(position)

                //어댑터에게 새로고침 시키기
                mAdater.notifyDataSetChanged()


            })
            deletAlert.setNegativeButton("취소",null)
            deletAlert.show()


          //LongClick은 반드시 Boolean값을 리턴해 줘야함
            return@setOnItemLongClickListener true
        }


    }
}