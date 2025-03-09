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

class Hindi_10_sb : AppCompatActivity() {
    var sb_hindi: WebView? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_hindi10_sb)

        sb_hindi = findViewById(R.id.hindi_pdf)

        sb_hindi!!.getSettings().javaScriptEnabled = true
        sb_hindi!!.setWebViewClient(WebViewClient())
        sb_hindi!!.loadUrl("https://drive.google.com/file/d/1oFrFIKNTeQ6k--7M9YQcnVf1LQnZDJ4V/view?usp=drive_link")
        supportActionBar!!.hide()

        val hin10_ai = findViewById<EditText>(R.id.hin10_ai)
        val hin10_aibtn = findViewById<Button>(R.id.hin10_aibtn)
        val hin10_res = findViewById<TextView>(R.id.hin10_res)

        hin10_aibtn.setOnClickListener {
            val prompt = hin10_ai.text.toString()
            lifecycleScope.launch {
                try {
                    val generativeModel = GenerativeModel(
                        modelName = "gemini-2.0-flash",
                        apiKey = "AIzaSyCZ-W568tMbiDcsdUWtJMAMGGTIURm36kI"
                    )
                    val response = generativeModel.generateContent(prompt)
                    hin10_res.text = response.text
                }catch(e:Exception){
                    hin10_res.text = "error ${e.message}"
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