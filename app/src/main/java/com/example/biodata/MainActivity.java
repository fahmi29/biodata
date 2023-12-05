package com.example.biodata;

import static android.app.ProgressDialog.show;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText etNama, etTempatLahir, etTanggalLahir, etNik, etAlamat, etJurusan, etId;
    private Button btnCreate, btnUpdate, btnDelete;

    private static final String BASE_URL = "http://192.168.1.89:3001"; // Ganti dengan URL API Anda

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        apiResponseTextView =

        etNama = findViewById(R.id.etNama);
        etTempatLahir = findViewById(R.id.etTempatLahir);
        etTanggalLahir = findViewById(R.id.etTanggalLahir);
        etNik = findViewById(R.id.etNik);
        etAlamat = findViewById(R.id.etAlamat);
        etJurusan = findViewById(R.id.etJurusan);
        etId = findViewById(R.id.etId);

        btnCreate = findViewById(R.id.btnCreate);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        TextView tv = (TextView) findViewById(R.id.hello);

//        String url = "http://192.168.75.148:3001/biodata/220e4b01-5c79-4a8d-8e73-87e3252dfb89";

        JsonObjectRequest request = new JsonObjectRequest(BASE_URL+"/biodata/get_biodata", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//            public void onResponse(JSONArray response) {
                try {
                    JSONObject result = response.getJSONObject("result");
                    String name = result.getString("nama_lengkap");
                    String tl = result.getString("tempat_lahir");
                    String tgl = result.getString("tanggal_lahir");
                    String nik = result.getString("nik");
                    String alamat = result.getString("alamat");
                    String jurusan = result.getString("jurusan");
                    String id = result.getString("id");
                    etNama.setText(name);
                    etTempatLahir.setText(tl);
                    etTanggalLahir.setText(tgl);
                    etNik.setText(nik);
                    etAlamat.setText(alamat);
                    etJurusan.setText(jurusan);
                    etId.setText(id);
                } catch (JSONException e) {
                    tv.setText("Error parsing JSON: " + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("error " + error.getMessage());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CreateBiodataTask().execute();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateBiodataTask().execute();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DeleteBiodataTask().execute();
            }
        });
    }

    private class CreateBiodataTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
//            String endPoint = BASE_URL+"/biodata"
            // Lakukan permintaan HTTP POST ke endpoint create
            // new ApiRequestTask().execute(endPoint)
//            Toast.makeText(context: MainActivity.this, text: "You Clicked", Toast.LENGTH_SHORT);.show();
//            Toast.makeText(context: MainActivity.this,)
            // dan kirimkan data biodata yang diisi oleh pengguna
            // Handle respon dari server dan kembalikan pesan atau respons yang sesuai
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // Handle respons dari server setelah membuat biodata
        }
    }

    private class UpdateBiodataTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            // Lakukan permintaan HTTP PUT ke endpoint update
            // dan kirimkan data biodata yang diisi oleh pengguna
            // Handle respon dari server dan kembalikan pesan atau respons yang sesuai
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // Handle respons dari server setelah mengupdate biodata
        }
    }

    private class DeleteBiodataTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            // Lakukan permintaan HTTP DELETE ke endpoint delete
            // dan kirimkan ID biodata yang diisi oleh pengguna
            // Handle respon dari server dan kembalikan pesan atau respons yang sesuai
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // Handle respons dari server setelah menghapus biodata
        }
    }
}
