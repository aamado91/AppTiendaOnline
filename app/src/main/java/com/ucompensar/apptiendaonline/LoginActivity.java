package com.ucompensar.apptiendaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnRegistroCliente;
    EditText txtUser;
    EditText txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.button_login);
        btnRegistroCliente = findViewById(R.id.button_registro);
        txtUser = findViewById(R.id.text_user);
        txtPassword = findViewById(R.id.text_password);

        btnLogin.setOnClickListener(new View.OnClickListener(){
           @Override
           public void  onClick(View view){

               if(txtUser.getText().toString().equals("admin") && txtPassword.getText().toString().equals("admin")) {
                   Toast.makeText(getApplicationContext(), "Iniciando sesión ...",Toast.LENGTH_SHORT).show();

                   Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
                   startActivity(intent);
               }else{
                   Toast.makeText(getApplicationContext(), "Datos Invalidos ...",Toast.LENGTH_SHORT).show();
               }
           }
        });

        btnRegistroCliente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent intent = new Intent(LoginActivity.this, RegistroClienteActivity.class);
                startActivity(intent);
            }
        });
    }
}