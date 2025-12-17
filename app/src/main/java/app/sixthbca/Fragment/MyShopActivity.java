package app.sixthbca.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import app.sixthbca.R;

public class MyShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_shop);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnHome = findViewById(R.id.btn_home);
        Button btnProfile = findViewById(R.id.btn_profile);
        Button btnSettings = findViewById(R.id.btn_settings);
        Button btnCart = findViewById(R.id.btn_cart);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyShopActivity.this, "You clicked Home", Toast.LENGTH_SHORT).show();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                HomeFragment home = new HomeFragment();
                transaction.replace(R.id.frame_layout, home);
                transaction.commit();
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyShopActivity.this, "You clicked Profile", Toast.LENGTH_SHORT).show();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                ProfileFragment profile = new ProfileFragment();
                transaction.replace(R.id.frame_layout, profile);
                transaction.commit();
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyShopActivity.this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                SettingsFragment settings = new SettingsFragment();
                transaction.replace(R.id.frame_layout, settings);
                transaction.commit();

            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyShopActivity.this, "You clicked Cart", Toast.LENGTH_SHORT).show();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                CartFragment cart = new CartFragment();
                transaction.replace(R.id.frame_layout, cart);
                transaction.commit();
            }
        });
    }
}