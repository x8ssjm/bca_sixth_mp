package app.sixthbca;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MyCustomizedListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_customized_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView list = findViewById(R.id.my_list);

        MyCustomAdapter adapter = new MyCustomAdapter(MyCustomizedListActivity.this);

    }
}

class MyCustomAdapter extends BaseAdapter {
    String[] name = {"Abhash", "Anjali", "Bimal", "Dipen", "Joyesh"};
    String[] nickName = {"Ab", "An", "Bi", "Di", "Jo"};
    int[] images = {R.drawable.google, R.drawable.google, R.drawable.google, R.drawable.google, R.drawable.google};


    Context context;

    MyCustomAdapter(Context c) {
        this.context = c;
    }

    @Override
    public int getCount() {
        return name.length;
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
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.my_list_row, parent, false);

            ImageView myImage = view.findViewById(R.id.img);
            TextView myName = view.findViewById(R.id.tv_name);
            TextView myNickName = view.findViewById(R.id.tv_nick);

            //set data
            myName.setText(name[position]);
            myNickName.setText(nickName[position]);
            myImage.setImageResource(images[position]);

        }
        return null;
    }
}