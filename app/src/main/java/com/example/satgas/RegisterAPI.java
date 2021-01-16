package com.example.satgas;

import android.renderscript.Sampler;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class RegisterAPI {
    @FormUrlEncoded
    @POST("update.php")
    Call<Sampler.Value> ubah(String pompa, @Field("id") String id,
                             @Field("value") String value) {
        return null;
    }
}
