package com.example.educationalbook.login_reg;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.educationalbook.MainActivity;
import com.example.educationalbook.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {

    TextInputEditText email_1,password_1;
    Button btnreg;
    FirebaseAuth mAuth;
    ProgressBar p_bar;
    TextView tview;
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration2);
        mAuth = FirebaseAuth.getInstance();
        email_1 = findViewById(R.id.Email);
        password_1 = findViewById(R.id.Password);
        btnreg = findViewById(R.id.Register);
        p_bar = findViewById(R.id.Progress_Bar);
        tview = findViewById(R.id.Login_here);
        tview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), login.class);
                startActivity(i);
                finish();
            }
        });
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p_bar.setVisibility(View.VISIBLE);
                String email, password;            //   <!-- checks email, password-->
                email = String.valueOf(email_1.getText());
                password = String.valueOf(password_1.getText());
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(Registration.this, "Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(Registration.this, "Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                p_bar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(Registration.this, "Account Created.",
                                            Toast.LENGTH_SHORT).show();
                                    // Sign in success, update UI with the signed-in user's information
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Registration.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}