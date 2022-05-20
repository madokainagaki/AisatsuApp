package jp.techacademy.madoka.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var newHour:Int? = null
    var newminute: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        imageView.setImageResource(R.drawable.aisatsu)
        textview1.setText("挨拶アプリ")
        textview2.setText("↓時刻を選択してください↓")
        button1.setText("時刻を選択")

        button1.setOnClickListener{
            showTimepicker()
        }
    }

    private fun showTimepicker(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener{ view, hour, minute ->
                newHour = hour
                newminute = minute
                aisatsu()
            },
            9,0,true)

        timePickerDialog.show()
    }

    private fun aisatsu(){
        textview2.text = "ただ今の時刻は${newHour}時${newminute}分です。"
        button1.setText("時刻を選択しなおす")

        if(newHour!! >= 2 && newHour!! <= 9){
            imageView.setImageResource(R.drawable.morning)
            textview1.setText("おはようございます")
        }else if(newHour!! >= 10 && newHour!! <= 17){
            imageView.setImageResource(R.drawable.day)
            textview1.setText("こんにちは")
        }else{
            imageView.setImageResource(R.drawable.night)
            textview1.setText("こんばんは")
        }
    }


}