package com.ucompensar.apptiendaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ucompensar.apptiendaonline.entities.Customer;
import com.ucompensar.apptiendaonline.repositories.RepositoryCustomer;

public class RegistroClienteActivity extends AppCompatActivity {

    Button btnCreate;
    EditText txtName;
    EditText txtEmail;
    EditText txtPhone;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registro_cliente);

        btnCreate = findViewById(R.id.button_crear_cliente);
        txtName = findViewById(R.id.text_nombre_completo);
        txtEmail = findViewById(R.id.text_correo);
        txtPhone = findViewById(R.id.text_telefono);
        txtPassword = findViewById(R.id.text_contrasena);

        btnCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Customer customer = new Customer();
                customer.setName(txtName.getText().toString());
                customer.setEmail(txtEmail.getText().toString());
                customer.setPhone(txtPhone.getText().toString());
                customer.setPassword(txtPassword.getText().toString());

                RepositoryCustomer repositoryCustomer = new RepositoryCustomer(RegistroClienteActivity.this);
                try {
                    customer.setId(repositoryCustomer.createCustomer(customer));

                    if (customer.getId() > 0){
                        Toast.makeText(getApplicationContext(), String.format("%s, bienvenido!", customer.getName()),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegistroClienteActivity.this, PrincipalActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Error",Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }
        });
    }
}