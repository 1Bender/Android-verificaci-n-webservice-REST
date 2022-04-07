package com.example.atentificacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.*;



import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    /*Variables que identifican los elementos existentes*/
    EditText usuario, contrasena;
    Button btLogin;
    String datosUsuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Definimos las variables con los ids de los elementos*/
        usuario = findViewById(R.id.edUsuario);
        contrasena = findViewById(R.id.edContra);
        btLogin = findViewById(R.id.btnentrar);
    }

    /**
     * Método que se ejecuta al pulsar el botón login. Este método obtiene los datos necesarios
     * del webservice usando los métodos de la clase SubProcesoWeb.
     * @param view
     * @throws JSONException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void acceso(View view) throws JSONException, ExecutionException, InterruptedException {

        SubProcesoWeb hiloAcceso = new SubProcesoWeb();

         datosUsuario =hiloAcceso.EntrarApp(usuario.getText().toString(),
                 contrasena.getText().toString());

         hiloAcceso.gestionRespuesta(datosUsuario, this);

    }
}