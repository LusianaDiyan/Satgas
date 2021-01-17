package com.example.satgas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.internal.bind.JsonTreeReader;

import java.util.HashMap;

public class Signup extends AppCompatActivity {
    EditText namaArea, luasArea, kebutuhanAir, kelembaban, jenisTnm;
    Button btnSubmit;

    public static final String URL = "http://192.168.0.104/satgas/create.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        namaArea = findViewById(R.id.namaArea);
        luasArea = findViewById(R.id.luasArea);
        kebutuhanAir = findViewById(R.id.kebutuhanAir);
        kelembaban = findViewById(R.id.kelembaban);
        jenisTnm = findViewById(R.id.jenisTnm);
        btnSubmit = findViewById(R.id.submitButton);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArea();
            }
        });

    }

    private void addArea(){
        final String nama = namaArea.getText().toString().trim();
        final String luas = luasArea.getText().toString().trim();
        final String air = kebutuhanAir.getText().toString().trim();
        final String moisture = kelembaban.getText().toString().trim();
        final String jenis = jenisTnm.getText().toString().trim();

        class AddArea extends AsyncTask<Void, Void, String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Signup.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Signup.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_EMP_NAME, nama);
                params.put(konfigurasi.KEY_EMP_JENIS, jenis);
                params.put(konfigurasi.KEY_EMP_LUAS, luas);
                params.put(konfigurasi.KEY_EMP_KEBUTUHAN, air);
                params.put(konfigurasi.KEY_EMP_MOISTURE, moisture);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD, params);
                return res;
            }
        }
        AddArea ae = new AddArea();
        ae.execute();
    }
}
