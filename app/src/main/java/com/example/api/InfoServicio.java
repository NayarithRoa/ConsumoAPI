package com.example.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class InfoServicio {
    //HEADER
    private OkHttpClient getHeader(){
        return  new OkHttpClient.Builder().addInterceptor(
                new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original= chain.request();
                        Request.Builder requestBuilder=original.newBuilder().addHeader("code-app", "2022*01")
                                .method(original.method(), original.body());

                        Request request= requestBuilder.build();
                        return chain.proceed(request);
                    }
                }
        ).build();
    }
    //CONEXION SERVICIO
    private Retrofit getRetrofit(){
        return  new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(this.getHeader())
                .build();
    }

    public Call<InfoResponse> getInfoService(){
        Call<InfoResponse> call = this.getRetrofit().create(InfoEndPoints.class).getInfo();
        return call;
    }
    public Call<Post> postInfoService(){
        Call<Post> call = this.getRetrofit().create(InfoEndPoints.class).postInfo();
        return call;
    }

}
