package com.example.educationalbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.educationalbook.FY.fy_main;
import com.example.educationalbook.login_reg.login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    Button btn;
    TextView tview;
    FirebaseUser user;
    ImageView tenth_img;
    ImageView twelfth_img;
    ImageView fy_img;

    WebView sb_eng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        btn = findViewById(R.id.Logout);
        user = auth.getCurrentUser();
        tenth_img = findViewById(R.id.tenth);
        sb_eng = findViewById(R.id.eng_pdf);

        if (sb_eng != null) {
            WebSettings webSettings = sb_eng.getSettings();
            webSettings.setJavaScriptEnabled(true);

            webSettings.setSupportZoom(true); // Enable zoom support
            webSettings.setBuiltInZoomControls(true); // Enable built-in zoom controls
            webSettings.setDisplayZoomControls(false);

            sb_eng.setWebViewClient(new WebViewClient());
            sb_eng.loadUrl("https://drive.google.com/file/d/1cIy4QHHWtapl0hzqbIRm8uxGYnapQldi/view?usp=drive_link");
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        tenth_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Tenth_Books.class);
                startActivity(i);
                finish();
            }
        });
        twelfth_img = findViewById(R.id.twelfth);
        twelfth_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Twelfth_Books.class);
                startActivity(i);
                finish();
            }
        });
        fy_img = findViewById(R.id.FY);
        fy_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), fy_main.class);
                startActivity(i);
                finish();
            }
        });
        if(user == null)
        {
            Intent i = new Intent(getApplicationContext(), login.class);
            startActivity(i);
            finish();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(getApplicationContext(), login.class);
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