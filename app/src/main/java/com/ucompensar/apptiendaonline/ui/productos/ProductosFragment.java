package com.ucompensar.apptiendaonline.ui.productos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ucompensar.apptiendaonline.R;
import com.ucompensar.apptiendaonline.entities.Product;
import com.ucompensar.apptiendaonline.repositories.RepositoryProducts;

import java.util.ArrayList;
import java.util.List;

public class ProductosFragment extends Fragment {

    RecyclerView recyclerViewProductos;
    List<Product> listProduct;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_productos, container, false);
        
        listProduct = new ArrayList<Product>();
        recyclerViewProductos = vista.findViewById(R.id.recyclerViewProductos);
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        cargarProductos();

        ProductosAdapter adapterProductos = new ProductosAdapter(listProduct);
        recyclerViewProductos.setAdapter(adapterProductos);

        return vista;
    }

    private void cargarProductos() {

        try (RepositoryProducts repositoryProducts = new RepositoryProducts(getActivity().getApplicationContext())) {
            listProduct = repositoryProducts.getProducts();

            listProduct.add(new Product(1,"Portatil ASUS", "$ 1.975.000", "Disponible", R.drawable.laptop_asus));
            listProduct.add(new Product(2,"Pantalla LG 34 Pul.", "$ 2.455.000", "Disponible", R.drawable.monitor));
            listProduct.add(new Product(3,"Teclado Logitech", "$ 932.999", "Disponible", R.drawable.teclado_logitech));
            listProduct.add(new Product(4,"Audifonos Logitech", "$ 109.999", "Disponible", R.drawable.headphones_logitech));
            listProduct.add(new Product(5,"Mouse Logitech", "$ 150.000", "Disponible", R.drawable.mouse));
            listProduct.add(new Product(6,"Disco Duro SSD", "$ 450.000", "Disponible", R.drawable.ssd));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}