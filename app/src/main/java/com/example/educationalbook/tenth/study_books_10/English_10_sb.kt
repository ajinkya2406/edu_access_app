package com.example.educationalbook.tenth.study_books_10

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.educationalbook.R
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class English_10_sb : AppCompatActivity() {
    var sb_eng: WebView? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_english10_sb)

        sb_eng = findViewById(R.id.eng_pdf)

        sb_eng!!.getSettings().javaScriptEnabled = true
        sb_eng!!.setWebViewClient(WebViewClient())
        sb_eng!!.loadUrl("https://drive.google.com/file/d/1obUWv2A5uGr3DTTfIodHMmYs1MZbtOWz/view?usp=drive_link")
        supportActionBar!!.hide()

        val eg10_ai = findViewById<EditText>(R.id.eg10_ai)
        val eg10_aibtn = findViewById<Button>(R.id.eg10_aibtn)
        val eg10_res = findViewById<TextView>(R.id.eg10_res)

        eg10_aibtn.setOnClickListener {
            val prompt = eg10_ai.text.toString()
            lifecycleScope.launch {
                try {
                    val generativeModel = GenerativeModel(
                        modelName = "gemini-2.0-flash",
                        apiKey = "AIzaSyCZ-W568tMbiDcsdUWtJMAMGGTIURm36kI"
                    )
                    val response = generativeModel.generateContent(prompt)
                    eg10_res.text = response.text
                }catch(e:Exception){
                    eg10_res.text = "error ${e.message}"
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}