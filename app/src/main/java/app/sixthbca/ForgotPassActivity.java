package app.sixthbca;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgotPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_pass);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String data = getIntent().getStringExtra("data");
        int myRoll = getIntent().getIntExtra("roll", 0);
        boolean loggedIn = getIntent().getBooleanExtra("isLoggedIn", false);
    }

    public void sendOTPClick(View view){
        //toast logic here
        Toast.makeText(ForgotPassActivity.this, "OTP sent successfully", Toast.LENGTH_LONG).show();
    }

}