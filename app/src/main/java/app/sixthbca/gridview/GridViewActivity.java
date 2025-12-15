package app.sixthbca.gridview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.sixthbca.R;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GridView mainGrid = findViewById(R.id.main_grid);
        GridAdapter adapter = new GridAdapter(GridViewActivity.this);
        mainGrid.setAdapter(adapter);
    }
}

class GridAdapter extends BaseAdapter {

    private final Context myContext;
    String[] name = {"Abhash", "Anjali", "Bimal", "Dipen", "Joyesh"};
    String[] nickName = {"Ab", "An", "Bi", "Di", "Jo"};
    int[] images = {R.drawable.google, R.drawable.google, R.drawable.google, R.drawable.google, R.drawable.google};

    GridAdapter(Context context) {
        myContext = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(myContext).inflate(R.layout.my_grid_design, parent, false);
        ImageView img = view.findViewById(R.id.grid_img);
        TextView tvName = view.findViewById(R.id.grid_name);
        TextView tvNickName = view.findViewById(R.id.grid_nickname);

        //now put the data in the view
        img.setImageResource(images[position]);
        tvName.setText(name[position]);
        tvNickName.setText(nickName[position]);

        return view;
    }
}