package com.example.satgas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class waterGate extends AppCompatActivity {
    public static final String URL = "http://192.168.43.163/satgas";

    SwitchCompat swPompa, swGate1, swGate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_gate);

        swPompa = findViewById(R.id.sw_pompa);
        swGate1 = findViewById(R.id.sw_gate1);
        swGate2 = findViewById(R.id.sw_gate2);

        //mengambil data dari edittext
        String pompa = swPompa.getText().toString();
        String pintu1 = swGate1.getText().toString();
        String pintu2 = swGate2.getText().toString();

       /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Sampler.Value> call = api.ubah(pompa, pintu1, pintu2);*/

        swPompa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swPompa.isChecked()){
                    //input nilai 1
                    Toast.makeText(getApplicationContext(), "Pompa Air Membuka", Toast.LENGTH_LONG).show(); // display the current state for switch's
                }else{
                    //input nilai 0
                    Toast.makeText(getApplicationContext(), "Pompa Air Menutup", Toast.LENGTH_LONG).show();
                }

            }
        });

        swGate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swGate1.isChecked()){
                    //input nilai 1

                    Toast.makeText(getApplicationContext(), "Pintu Air 1 Membuka", Toast.LENGTH_LONG).show();
                }else{
                    //input nilai 0
                    Toast.makeText(getApplicationContext(), "Pintu Air 1 Menutup", Toast.LENGTH_LONG).show();
                }
            }
        });

        swGate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swGate2.isChecked()){
                    //input nilai 1
                    Toast.makeText(getApplicationContext(), "Pintu Air 2 Membuka", Toast.LENGTH_LONG).show();
                }else{
                    //input nilai 0
                    Toast.makeText(getApplicationContext(), "Pintu Air 2 Menutup", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
