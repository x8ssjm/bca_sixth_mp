package app.sixthbca;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnContext = findViewById(R.id.btn_context_menu);
        registerForContextMenu(btnContext);
    }


    // applying options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menuId = item.getItemId();
        if (menuId == R.id.menu_refresh) {
            //todo: make a toast that says the item is clicked
        } else if (menuId == R.id.menu_settings) {

        }
        return super.onOptionsItemSelected(item);
    }

    // applying context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int menuId = item.getItemId();
        if (menuId == R.id.cmenu_one) {
            Toast.makeText(this, "Item 1 is clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    //applying pop menu
    public void ShowPopupMenu(View view) {
        PopupMenu popupmenu = new PopupMenu(this, view);
        popupmenu.getMenuInflater().inflate(R.menu.popup_menu, popupmenu.getMenu());
        popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuId = item.getItemId();
                if (menuId == R.id.pop_one) {
                    Toast.makeText(DashboardActivity.this, "Item 1 is clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        popupmenu.show();
    }


    //applyling Toasts on buttonclicks
    public void SetupProfileCLick(View view) {
        //toast goes here
        Toast.makeText(DashboardActivity.this, "Redirecting to user's profile", Toast.LENGTH_SHORT).show();
    }

    public void SkipAndContinueClick(View v) {
        //toast goes here
        Toast.makeText(DashboardActivity.this, "Redirecting to the main dashboard", Toast.LENGTH_SHORT).show();

    }

}