package com.example.educationalbook.twelfth.exam_paper_12;

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
import com.example.educationalbook.twelfth.shorts_notes_12.chem_12;
import com.example.educationalbook.twelfth.shorts_notes_12.hindi_12;
import com.example.educationalbook.twelfth.shorts_notes_12.math_12;
import com.example.educationalbook.twelfth.shorts_notes_12.phy_12;

public class science_ep_12 extends AppCompatActivity {

    ImageView sbback;
    ImageView eng_10_btn;
    ImageView hindi_10_btn;
    ImageView math_10_btn;
    ImageView sst_10_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_science_ep12);

        sbback = findViewById(R.id.sb_back);
        eng_10_btn = findViewById(R.id.sb_eng);
        hindi_10_btn = findViewById(R.id.sb_hindi);
        math_10_btn = findViewById(R.id.sb_maths);
        sst_10_btn = findViewById(R.id.sb_sst);

        sbback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), exam_paper_12.class);
                startActivity(i);
                finish();
            }
        });
        eng_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), phy.class);
                startActivity(i);
            }
        });
        hindi_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), eng.class);
                startActivity(i);
            }
        });
        math_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), math.class);
                startActivity(i);
            }
        });
        sst_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), chem.class);
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