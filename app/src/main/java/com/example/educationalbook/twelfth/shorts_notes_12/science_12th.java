package com.example.educationalbook.twelfth.shorts_notes_12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.educationalbook.R;
import com.example.educationalbook.Tenth_Books;
import com.example.educationalbook.tenth.study_books_10.English_10_sb;
import com.example.educationalbook.tenth.study_books_10.Hindi_10_sb;
import com.example.educationalbook.tenth.study_books_10.Maths_10_sb;
import com.example.educationalbook.tenth.study_books_10.SST_10_sb;
import com.example.educationalbook.tenth.study_books_10.Science_10_sb;

public class science_12th extends AppCompatActivity {

    ImageView sbback;
    ImageView eng_10_btn;
    ImageView hindi_10_btn;
    ImageView math_10_btn;
    ImageView sst_10_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_science12th);
        sbback = findViewById(R.id.sb_back);
        eng_10_btn = findViewById(R.id.sb_eng);
        hindi_10_btn = findViewById(R.id.sb_hindi);
        math_10_btn = findViewById(R.id.sb_maths);
        sst_10_btn = findViewById(R.id.sb_sst);

        sbback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Tenth_Books.class);
                startActivity(i);
                finish();
            }
        });
        eng_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), phy_12.class);
                startActivity(i);
            }
        });
        hindi_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), hindi_12.class);
                startActivity(i);
            }
        });
        math_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), math_12.class);
                startActivity(i);
            }
        });
        sst_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), chem_12.class);
                startActivity(i);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}