package com.ucompensar.apptiendaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class RegistroClienteActivity extends AppCompatActivity {

    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_registro_cliente);

        btnCrear = findViewById(R.id.button_crear_cliente);

        btnCrear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Toast.makeText(getApplicationContext(), "Bienvenido a Tienda Online!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistroClienteActivity.this, PrincipalActivity.class);
                startActivity(intent);
            }
        });
    }
}