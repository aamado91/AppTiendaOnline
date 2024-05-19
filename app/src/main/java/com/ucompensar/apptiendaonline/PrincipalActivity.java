package com.ucompensar.apptiendaonline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.ucompensar.apptiendaonline.common.AppSesion;
import com.ucompensar.apptiendaonline.databinding.ActivityPrincipalBinding;
import com.ucompensar.apptiendaonline.ui.productos.ProductosGestionActivity;
import com.ucompensar.apptiendaonline.ui.ubicacion.UbicacionActivity;

public class PrincipalActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityPrincipalBinding binding;

    ImageView imageViewUser;
    TextView textViewUserName;
    TextView textViewEmail;
    Button btnAdminProducts;
    Button btnMapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarPrincipal.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_productos, R.id.nav_compras).setOpenableLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_principal);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        View headerView = navigationView.getHeaderView(0);
        textViewUserName = headerView.findViewById(R.id.textViewName);
        textViewEmail = headerView.findViewById(R.id.textViewEmail);
        imageViewUser = headerView.findViewById(R.id.imageViewUser);
        btnAdminProducts = headerView.findViewById(R.id.button_admin_products);
        btnMapa = headerView.findViewById(R.id.button_showMap);

        textViewUserName.setText(AppSesion.User.getName());
        textViewEmail.setText(AppSesion.User.getEmail());

        if (AppSesion.User.getGender() == 1) {
            imageViewUser.setImageResource(R.drawable.user_men);
        }else {
            imageViewUser.setImageResource(R.drawable.user_women);
        }

        btnAdminProducts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent intent = new Intent(PrincipalActivity.this, ProductosGestionActivity.class);
                startActivity(intent);
            }
        });

        btnMapa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent intent = new Intent(PrincipalActivity.this, UbicacionActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_principal);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}