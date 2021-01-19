package com.example.satgas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Signup extends AppCompatActivity {
    EditText idArea, namaArea, luasArea, kebutuhanAir, kelembaban, jenisTnm;
    Button btnSubmit;

    public static final String URL = "https://192.168.0.104/satgas/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        idArea = findViewById(R.id.idArea);
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
        final String id = idArea.getText().toString().trim();
        final String nama = namaArea.getText().toString().trim();
        final String luas = luasArea.getText().toString().trim();
        final String air = kebutuhanAir.getText().toString().trim();
        final String moisture = kelembaban.getText().toString().trim();
        final String jenis = jenisTnm.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<value> call = api.area(id, nama, luas, air, moisture, jenis);
        call.enqueue(new Callback<value>() {
            @Override
            public void onResponse(Call<value> call, Response<value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                if (value.equals("1")) {
                    Toast.makeText(Signup.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Signup.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<value> call, Throwable t) {
                Toast.makeText(Signup.this, "Registrasi sedang diproses!", Toast.LENGTH_SHORT).show();
            }
        });

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
                params.put(konfigurasi.KEY_EMP_ID, id);
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
