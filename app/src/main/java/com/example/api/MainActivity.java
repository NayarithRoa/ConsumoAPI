package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);

        Call<InfoResponse> call =(new InfoServicio()).getInfoService();

        call.enqueue(new Callback<InfoResponse>() {
            @Override
            public void onResponse(Call<InfoResponse> call, Response<InfoResponse> response) {
                if (response.isSuccessful()){
                    InfoResponse infoResponse = response.body();
                    String contenido="";

                    for (int i=0;i<infoResponse.data.size();i++){
                        contenido += "NOMBRE: " + infoResponse.data.get(i).getNames()+" "+ "\n";
                        contenido += "USUARIO: " + infoResponse.data.get(i).getUsername()+ "\n";
                        contenido += "ROL: " + infoResponse.data.get(i).getRol()+ "\n";
                        contenido += "FECHA CREACIÓN: " + infoResponse.data.get(i).getCreated_at()+ "\n";
                        contenido += "FECHA ACTUALIZACIÓN: " + infoResponse.data.get(i).getUpdated_at()+ "\n";
                        resultado.append(contenido);

                    }
                }

                else {
                    resultado.setText("Codigo: "+ response.code());
                    return;
                }
            }

            @Override
            public void onFailure(Call<InfoResponse> call, Throwable t) {

            }
        });
    }
}