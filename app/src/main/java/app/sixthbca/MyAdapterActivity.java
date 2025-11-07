package app.sixthbca;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MyAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner comboBox = findViewById(R.id.spin);
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_list_item_1);

        // fetching the properties for the dropdown (such as text's color, style, etc)
        adapter.setDropDownViewResource(R.layout.row_days);

        //displaying the adapter
       comboBox.setAdapter(adapter);

       //performing onlick listeners
        comboBox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int selectedPosition = position;
                Toast.makeText(MyAdapterActivity.this, "I am at position: " + selectedPosition, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MyAdapterActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}