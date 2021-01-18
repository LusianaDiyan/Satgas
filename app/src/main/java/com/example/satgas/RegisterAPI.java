package com.example.satgas;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/insert.php")
    Call<value> area(@Field("id") String id,
                             @Field("nama_area") String nama,
                             @Field("luas_area") String luas,
                             @Field("kebutuhan_air") String air,
                             @Field("Moisture") String kelembaban,
                             @Field("jenis_tanaman") String tanaman);
}
