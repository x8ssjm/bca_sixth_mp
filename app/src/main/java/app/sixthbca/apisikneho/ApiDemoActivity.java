package app.sixthbca.apisikneho;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import app.sixthbca.R;

public class ApiDemoActivity extends AppCompatActivity {

    Button btnLoad;
    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_api_demo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnLoad = findViewById(R.id.btnClickkme);
        txtData = findViewById(R.id.btnTexttt);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadData().execute();
            }
        });
    }

    private class LoadData extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtData.setText("Loading...");
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/posts");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                StringBuilder result = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                return result.toString();

            } catch (Exception e) {
                return e.toString();
            }
        }

        protected void onPostExecute(String result) {

            try {
                JSONArray jsonArray = new JSONArray(result);

                StringBuilder displayData = new StringBuilder();

                for (int i=0; i<5; i++){
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String title = obj.getString("title");
                    String body = obj.getString("body");

                    displayData.append("Post").append(i+1).append("\n");
                    displayData.append("Title: ").append(title).append("\n");
                    displayData.append("Body: ").append(body).append("\n\n");
                }

                txtData.setText(displayData.toString());

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}