package com.ucompensar.apptiendaonline.ui.productos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ucompensar.apptiendaonline.PrincipalActivity;
import com.ucompensar.apptiendaonline.R;
import com.ucompensar.apptiendaonline.RegistroClienteActivity;
import com.ucompensar.apptiendaonline.common.AppSesion;
import com.ucompensar.apptiendaonline.entities.Customer;
import com.ucompensar.apptiendaonline.entities.Product;
import com.ucompensar.apptiendaonline.repositories.RepositoryCustomer;
import com.ucompensar.apptiendaonline.repositories.RepositoryProducts;

public class ProductosGestionActivity extends AppCompatActivity {

    Button btnCreate;
    EditText txtName;
    EditText txtPrice;
    EditText txtState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_productos_gestion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_productos_gestion);

        btnCreate = findViewById(R.id.buttonCreateProduct);
        txtName = findViewById(R.id.txtNameProduct);
        txtPrice = findViewById(R.id.txtPriceProduct);
        txtState = findViewById(R.id.txtStateProduct);

        btnCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Product product = new Product();
                product.setName(txtName.getText().toString());
                product.setPrice(txtPrice.getText().toString());
                product.setState(txtState.getText().toString());
                product.setImage(R.drawable.producto_base);

                RepositoryProducts repositoryProducts = new RepositoryProducts(ProductosGestionActivity.this);
                try {
                    product.setId(repositoryProducts.createProduct(product));

                    if (product.getId() > 0){

                        //AppSesion.User = customer;

                        Toast.makeText(getApplicationContext(), String.format("Producto [%s] creado exitosamente", product.getName()),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ProductosGestionActivity.this, PrincipalActivity.class);
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