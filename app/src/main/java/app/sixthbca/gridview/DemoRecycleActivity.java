package app.sixthbca.gridview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.sixthbca.R;

public class DemoRecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo_recycle);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView rv = findViewById(R.id.recyclerView);
        RecycleAdapter adapter = new RecycleAdapter();
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        GridLayoutManager layoutManager = new GridLayoutManager(
                this,
                4, // spancount = rows (because orientation is horizontal
                GridLayoutManager.HORIZONTAL, // key: horizontal scrolling
                false
        );
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }
}

class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyviewHolder> {

    String[] name = {"Abhash", "Anjali", "Bimal", "Dipen", "Joyesh"};
    String[] nickName = {"Ab", "An", "Bi", "Di", "Jo"};
    int[] images = {R.drawable.google, R.drawable.google, R.drawable.google, R.drawable.google, R.drawable.google};

    @NonNull
    @Override
    public RecycleAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_grid_design, parent, false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.MyviewHolder holder, int position) {
        holder.img.setImageResource(images[position]);
        holder.tvName.setText(name[position]);
        holder.tvNickName.setText(nickName[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tvName;
        TextView tvNickName;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.grid_img);
            tvName = itemView.findViewById(R.id.grid_name);
            tvNickName = itemView.findViewById(R.id.grid_nickname);
        }
    }
}