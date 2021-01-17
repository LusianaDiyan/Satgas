package com.example.satgas;

import android.renderscript.Sampler;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/create.php")
    Call<Sampler.Value> area(@Field("id") String id,
                             @Field("namaarea") String namaarea,
                             @Field("luas") String luas,
                             @Field("kebair") String air,
                             @Field("kelembaban") String kelembaban,
                             @Field("tanaman") String tanaman);
}
