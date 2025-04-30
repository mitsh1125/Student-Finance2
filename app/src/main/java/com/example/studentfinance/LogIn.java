package com.example.studentfinance;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.TextView;
public class LogIn extends AppCompatActivity {


    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private TextView signUpText;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        signUpText = findViewById(R.id.SignUptext);
        mAuth = FirebaseAuth.getInstance();












    }
}