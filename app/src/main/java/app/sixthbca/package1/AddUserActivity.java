package app.sixthbca.package1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.sixthbca.R;

public class AddUserActivity extends AppCompatActivity {
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //logics
        /*EditText name = findViewById(R.id.etName);
        String myName = name.getText().toString();

        Button btnSaveUser = findViewById(R.id.btnSaveUser);
        Button btnCancel = findViewById(R.id.btnCancel);*/

        name = findViewById(R.id.etName);

    }

    public void OnButtonClick(View view) {
        int id = view.getId(); //to get the id
        if (id == R.id.btnSaveUser) {
            String myName = name.getText().toString();
            Toast.makeText(this, myName, Toast.LENGTH_SHORT).show();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", myName);
            setResult(RESULT_OK, resultIntent);
            finish(); //close AddUserActivity and return result to ParentActivity
        }
        if (id == R.id.btnCancel) {
            Intent resultIntent = new Intent();
            setResult(RESULT_CANCELED, resultIntent);
            finish();
            Toast.makeText(this, "Cancel button has been clicked", Toast.LENGTH_SHORT).show();
        }
    }
}