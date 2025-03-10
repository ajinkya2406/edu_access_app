package com.example.educationalbook.FY.ep_fy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.educationalbook.FY.fy_main;
import com.example.educationalbook.FY.sb_fy.sb_fy_acp;
import com.example.educationalbook.FY.sb_fy.sb_fy_am;
import com.example.educationalbook.FY.sb_fy.sb_fy_bc;
import com.example.educationalbook.FY.sb_fy.sb_fy_co;
import com.example.educationalbook.FY.sb_fy.sb_fy_cp;
import com.example.educationalbook.FY.sb_fy.sb_fy_dbms;
import com.example.educationalbook.FY.sb_fy.sb_fy_foc;
import com.example.educationalbook.FY.sb_fy.sb_fy_os;
import com.example.educationalbook.R;

public class ep_bca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView fyback;
        ImageView sbcp;
        ImageView sbfoc;
        ImageView sbam;
        ImageView sbbc;
        ImageView sbco;
        ImageView sbacp;
        ImageView sbos;
        ImageView sbdbms;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ep_bca);
        sbcp = findViewById(R.id.sb_cp);
        sbfoc = findViewById(R.id.sb_foc);
        sbam = findViewById(R.id.sb_am);
        sbbc = findViewById(R.id.sb_bc);
        sbco = findViewById(R.id.sb_co);
        sbacp = findViewById(R.id.sb_acp);
        sbos = findViewById(R.id.sb_os);
        sbdbms = findViewById(R.id.sb_dbms);
        fyback = findViewById(R.id.sb_back);

        fyback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), fy_main.class);
                startActivity(i);
                finish();
            }
        });
        sbcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ep_cp.class);
                startActivity(i);
                finish();
            }
        });
        sbfoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ep_foc.class);
                startActivity(i);
                finish();
            }
        });
        sbam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ep_am.class);
                startActivity(i);
                finish();
            }
        });
        sbbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ep_bc.class);
                startActivity(i);
                finish();
            }
        });
        sbacp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ep_acp.class);
                startActivity(i);
                finish();
            }
        });
        sbco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ep_co.class);
                startActivity(i);
                finish();
            }
        });
        sbos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ep_os_fy.class);
                startActivity(i);
                finish();
            }
        });
        sbdbms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ep_dbms.class);
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