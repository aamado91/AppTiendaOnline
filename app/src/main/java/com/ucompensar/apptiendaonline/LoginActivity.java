package com.ucompensar.apptiendaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Window;
import android.view.WindowManager;

import com.ucompensar.apptiendaonline.db.DbHelper;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnRegistroCliente;
    EditText txtUser;
    EditText txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.button_login);
        btnRegistroCliente = findViewById(R.id.button_registro);
        txtUser = findViewById(R.id.text_user);
        txtPassword = findViewById(R.id.text_password);

        // Create an instance of the class DbHelper for the database administration
        DbHelper dbHelper = new DbHelper(LoginActivity.this);
        // Get instance of the database in readonly mode
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        if (dbHelper != null) {
            Toast.makeText(getApplicationContext(), "DATABASE CREATED", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "CREATION DATABASE FAILED",Toast.LENGTH_SHORT).show();
        }

        btnLogin.setOnClickListener(new View.OnClickListener(){
           @Override
           public void  onClick(View view){

               if(txtUser.getText().toString().equals("aamado@ucompensar.edu.co") && txtPassword.getText().toString().equals("admin")) {
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