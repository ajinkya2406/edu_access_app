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
import com.example.educationalbook.Twelfth_Books;
import com.example.educationalbook.tenth.study_books_10.English_10_sb;
import com.example.educationalbook.tenth.study_books_10.Hindi_10_sb;
import com.example.educationalbook.tenth.study_books_10.Maths_10_sb;
import com.example.educationalbook.tenth.study_books_10.SST_10_sb;
import com.example.educationalbook.tenth.study_books_10.Science_10_sb;

public class short_notes_12 extends AppCompatActivity {

    ImageView sbback;
    ImageView eng_10_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_short_notes12);

        sbback = findViewById(R.id.sb_back_12);
        eng_10_btn = findViewById(R.id.sb_eng_12);

        sbback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Twelfth_Books.class);
                startActivity(i);
                finish();
            }
        });
        eng_10_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), science_12th.class);
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