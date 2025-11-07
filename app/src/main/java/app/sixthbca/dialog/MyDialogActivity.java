package app.sixthbca.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.sixthbca.R;

public class MyDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_dialog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnShowDialog = findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: write dialog box code in here
                AlertDialog.Builder dialog = new AlertDialog.Builder(MyDialogActivity.this);
                dialog.setTitle("This is a title");
                dialog.setCancelable(false);
                dialog.setMessage("this is a message, this is a message, this is a message!");
                dialog.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo: write the logic of this button
                        Toast.makeText(MyDialogActivity.this, "You accepted the dialog", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo: write the logic of this button
                        Toast.makeText(MyDialogActivity.this, "You declined the dialog", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                dialog.setNeutralButton("Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MyDialogActivity.this, "You chose later", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });


        //dialog with photo
        Button dialogPhoto = findViewById(R.id.btn_show_dialogPhoto);
        dialogPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog myDialog = new Dialog(MyDialogActivity.this);
                myDialog.setContentView(R.layout.custom_dialog_box);
                myDialog.setCancelable(false);

                //start referencing views
                Button btnLike = myDialog.findViewById(R.id.btnLike);
                Button btnDislike = myDialog.findViewById(R.id.btnNo);

                btnLike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MyDialogActivity.this, "You liked the photo", Toast.LENGTH_SHORT).show();
                        myDialog.dismiss();
                    }
                });

                btnDislike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MyDialogActivity.this, "You didn't like the photo", Toast.LENGTH_SHORT).show();
                        myDialog.dismiss();
                    }
                });

                myDialog.show();
            }
        });





    }
}