package com.example.studentfinance;
import com.google.firebase.auth.FirebaseUser;

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

        loginButton.setOnClickListener(v -> loginUser());

        signUpText.setOnClickListener(v -> {
            // Redirect to sign-up activity
            Toast.makeText(this, "Redirect to Sign-Up", Toast.LENGTH_SHORT).show();
        });


    }

    private void loginUser() {

        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user   = mAuth.getCurrentUser();
                        Toast.makeText(LogIn.this, "Login successful!",
                                Toast.LENGTH_SHORT).show();
                        // Redirect to main activity or dashboard
                    } else {
                        Toast.makeText(LogIn.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}