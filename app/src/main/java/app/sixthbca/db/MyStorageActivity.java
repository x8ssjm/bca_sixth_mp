package app.sixthbca.db;

import android.database.Cursor;
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

import app.sixthbca.R;

public class MyStorageActivity extends AppCompatActivity {
    MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_storage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new MyDatabaseHelper(this);
        EditText Dbname = findViewById(R.id.db_name);
        EditText DbContact = findViewById(R.id.db_contact);
        EditText DbAddress = findViewById(R.id.db_address);

        Button btn_add = findViewById(R.id.btn_add);
        Button btn_view = findViewById(R.id.btn_view);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_update = findViewById(R.id.btn_update);

        //onclick listener for the add (calls the add page)
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Dbname.getText().toString();
                String address = DbAddress.getText().toString();
                String contact = DbContact.getText().toString();

                //int contact = Integer.parseInt(DbContact.getText().toString());

                if(name.isEmpty()&& address.isEmpty()&& contact.isEmpty()){
                    Toast.makeText(MyStorageActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }else {
                    int contactNumber = Integer.parseInt(contact);
                    dbHelper.insertUSer(name, address, contactNumber);
                    Toast.makeText(MyStorageActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();

                    Dbname.setText("");
                    DbAddress.setText("");
                    DbContact.setText("");
                }



////                Toast.makeText(MyStorageActivity.this, "Added", Toast.LENGTH_SHORT).show();
//                if (!name.isEmpty() && !address.isEmpty() && !contact.isEmpty()){
//                    int contactNumber = Integer.parseInt(contact);
//                    dbHelper.insertUSer(name, address, contactNumber);
//                    Toast.makeText(MyStorageActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MyStorageActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
//                }
            }
        });


        //onclick listener for the view (calls the view page)
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyStorageActivity.this, "View ko toast", Toast.LENGTH_SHORT).show();
                Cursor returnedData = dbHelper.getAllUser();

                while (returnedData.moveToNext()){
                    int id = returnedData.getInt(returnedData.getColumnIndexOrThrow("id"));
                    String name = returnedData.getString(returnedData.getColumnIndexOrThrow("name"));
                    String address = returnedData.getString(returnedData.getColumnIndexOrThrow("address"));
                    int contact = returnedData.getInt(returnedData.getColumnIndexOrThrow("contact"));

                    Log.e("Data haru", id + " " + name + " " + address + " " + contact);
                }
            }
        });

        //onclick listener for the delete (calls the delete page)
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteUser(5);
                Toast.makeText(MyStorageActivity.this, "delete ko toast", Toast.LENGTH_SHORT).show();
            }
        });
        //onclick listener for the update (calls the update page)
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyStorageActivity.this, "update ko toast", Toast.LENGTH_SHORT).show();
                dbHelper.updateUser(1,"unknown", "Jack");
                dbHelper.updateUser(5,"manchhe", "narka bahadur");
            }
        });

    }
}