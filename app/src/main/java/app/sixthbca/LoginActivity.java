package app.sixthbca;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnForgotPass = findViewById(R.id.btn_Forgot);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                yo chai log ho, just to check if the button is clicking or not
                Log.e("forgot btn", "forgot btn is working");


                /*1. euta activity banaune
                2. tei classs ko lagi design banaune
                3. tei activity ma switch hune code yo button click garda lekhna paryo
                4. switch huda data ni pathauna paryo
                 */
                Intent intent = new Intent(LoginActivity.this,
                        ForgotPassActivity.class);
                intent.putExtra("data", "hello");
                intent.putExtra("roll", 10);
                intent.putExtra("isLoggedIn", false);
                startActivity(intent);

            }
        });

//        Student std = new Student();
//        std.setName(sdfs);
    }


    public void LoginClick(View view) {

        String email = etEmail.getText().toString().trim();
        String pass = etPassword.getText().toString().trim();

        Log.e("email: ", email);
        Log.e("pass: ", pass);

        if(email.isEmpty()){
            etEmail.setError("Email is required");
        }

        if(pass.isEmpty()){
            etPassword.setError("Password is required");
        }

        if (!email.isEmpty() && !pass.isEmpty()) {

            // TODO: logic here
            Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(LoginActivity.this,
                    DashboardActivity.class);
            startActivity(intent);
        } else {
            // TODO: logic here
            Toast.makeText(LoginActivity.this, "Error while logging in", Toast.LENGTH_LONG).show();
        }
    }
}