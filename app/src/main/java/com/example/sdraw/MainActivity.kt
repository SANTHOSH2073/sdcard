package com.example.sdraw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etName : EditText = findViewById(R.id.etname)
        val etCGPA : EditText = findViewById(R.id.etcgpa)
        val btsave : Button = findViewById(R.id.btnsave)
        val btLoad : Button = findViewById(R.id.btnload)
        btsave.setOnClickListener{
            val name = etName.text.toString()
            val cgpa = etCGPA.text.toString()

            val file = File(getExternalFilesDir(null),"student.txt")
            val fos = FileOutputStream(file,true)
            fos.write("$name,$cgpa".toByteArray())
            fos.close()
            etName.setText("")
            etCGPA.setText("")
        }
        btLoad.setOnClickListener{
            val file = File(getExternalFilesDir(null),"student.txt")
            val finp=FileInputStream(file)
            val isr=InputStreamReader(finp)
            val br = BufferedReader(isr)
            val line: String
            line =br.readLine()
            val part = line.split(",")
            etName.setText(part[0])
            etCGPA.setText(part[1])
            finp.close()
        }
    }
}