package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class NuevoUsuario extends AppCompatActivity {

    EditText txtnames,txtusername,txtrol,txtcreated,txtupdated;
    TextView txtMensaje;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);
        int id=1;
        txtnames = findViewById(R.id.txtnames);
        txtusername = findViewById(R.id.txtusername);
        txtrol = findViewById(R.id.txtrol);
        txtcreated = findViewById(R.id.txtcreated);
        txtupdated = findViewById(R.id.txtupdated);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        txtMensaje = findViewById(R.id.txtMensaje);


        btnRegistrar.setOnClickListener(view -> {
            CallRetrofit();
        });

    }
    private void CallRetrofit() {

        Post postbody = new Post(1, txtnames.getText().toString(), txtusername.getText().toString(), txtrol.getText().toString(), txtcreated.getText().toString(), txtupdated.getText().toString());

        Call<Post> call = (new InfoServicio()).postInfoService();
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                txtMensaje.setText("REGISTRO ALMACENADO");
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }
}