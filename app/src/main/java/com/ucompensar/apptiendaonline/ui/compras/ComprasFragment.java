package com.ucompensar.apptiendaonline.ui.compras;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.ucompensar.apptiendaonline.LoginActivity;
import com.ucompensar.apptiendaonline.PrincipalActivity;
import com.ucompensar.apptiendaonline.R;
import com.ucompensar.apptiendaonline.databinding.FragmentComprasBinding;
import com.ucompensar.apptiendaonline.ui.productos.Producto;
import com.ucompensar.apptiendaonline.ui.productos.ProductosAdapter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ComprasFragment extends Fragment {

    RecyclerView recyclerViewCarrito;
    List<ProductoCarrito> listaProductosCarrito;

    TextView subtotalTextView, totalTextView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_compras, container, false);

        listaProductosCarrito = new ArrayList<ProductoCarrito>();
        recyclerViewCarrito = vista.findViewById(R.id.recyclerViewCarrito);
        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(getContext()));
        subtotalTextView = vista.findViewById(R.id.subtotalTextView);
        totalTextView = vista.findViewById(R.id.totalTextView);

        cargarCarrito();
        calcularTotales();

        ComprasAdapter adapterCompras= new ComprasAdapter(listaProductosCarrito);
        recyclerViewCarrito.setAdapter(adapterCompras);

        return vista;
    }

    private void cargarCarrito() {
        Producto producto = new Producto("Teclado Logitech", "932999", "", R.drawable.teclado_logitech);
        listaProductosCarrito.add(new ProductoCarrito(producto, 2));
    }

    private void calcularTotales(){

        int subtotal = 0;
        int total = 0;

        for(int i = 0; i < listaProductosCarrito.size(); i++){
            subtotal = subtotal + listaProductosCarrito.get(i).getTotalProducto();
        }

        total = subtotal;

        Locale localizacion = new Locale ("es", "CO");
        NumberFormat formatoNumero = NumberFormat.getInstance (localizacion);

        subtotalTextView.setText("$ " + formatoNumero.format(subtotal));
        totalTextView.setText("$ " + formatoNumero.format(total));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}