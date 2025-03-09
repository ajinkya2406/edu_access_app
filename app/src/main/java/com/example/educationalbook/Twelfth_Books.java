package com.example.educationalbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.educationalbook.twelfth.exam_paper_12.exam_paper_12;
import com.example.educationalbook.twelfth.shorts_notes_12.science_12th;
import com.example.educationalbook.twelfth.shorts_notes_12.short_notes_12;
import com.example.educationalbook.twelfth.study_books_12.science_sb_12;
import com.example.educationalbook.twelfth.study_books_12.study_books_12;

public class Twelfth_Books extends AppCompatActivity {

    ImageView twback;
    ImageView sb10;
    ImageView sn10;
    ImageView ep10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twelfth_books);

        sb10 = findViewById(R.id.sb_10);
        sn10 = findViewById(R.id.sn_10);
        ep10 = findViewById(R.id.ep_10);

        twback = findViewById(R.id.twelfth_back);

        twback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        sb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), study_books_12.class);
                startActivity(i);
                finish();
            }
        });
        sn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), short_notes_12.class);
                startActivity(i);
                finish();
            }
        });
        ep10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), exam_paper_12.class);
                startActivity(i);
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}