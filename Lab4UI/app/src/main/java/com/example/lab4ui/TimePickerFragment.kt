package com.example.lab4ui

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.widget.Toast.makeText


class TimePickerFragment : DialogFragment(),TimePickerDialog.OnTimeSetListener{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val  c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        return TimePickerDialog(activity, 2,this,hour,minute,true)
    }

    override fun onTimeSet(view: TimePicker?, hourofDay: Int, minute: Int) {
        val muniteNew : String = if(minute<10) "0${minute.toString() }" else minute.toString()
        activity?.text_time?.text = "$hourofDay:$muniteNew"
    }

    override fun onCancel(dialog: DialogInterface?) {
        Toast.makeText(activity,"Please select a time." ,Toast.LENGTH_SHORT).show()
    super.onCancel(dialog)
    }


}