package app.sixthbca.package1;

import android.app.BackgroundServiceStartNotAllowedException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.sixthbca.R;

public class ParentActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> mStartForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_parent);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //register the launcher to get the result
        //hover and click alt+enter to define variables...
        mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                int resultCode = result.getResultCode();
                if (resultCode == -1) {

                    Intent data = result.getData();
                    String username = data.getStringExtra("name");
                    Log.e("sdefds", username);
                    Toast.makeText(ParentActivity.this, username, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void AddUser(View view) {
        Intent intent = new Intent(ParentActivity.this, AddUserActivity.class);
        mStartForResult.launch(intent);
    }
}