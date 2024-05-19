package com.ucompensar.apptiendaonline.ui.productos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ucompensar.apptiendaonline.R;
import com.ucompensar.apptiendaonline.entities.Product;

import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder> {
    private List<Product> listaProductos;

    public ProductosAdapter(List<Product> listaProductos){
        this.listaProductos = listaProductos;
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_productos, null, false);
        return new ProductoViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(ProductoViewHolder holder, int position) {
        holder.bindData(listaProductos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public void serItems(List<Product> productos){
        this.listaProductos = productos;
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {
        ImageView iconoImagen;
        TextView nombreProducto, valorProducto, estadoProducto;

        public ProductoViewHolder(View itemVista){
            super(itemVista);
            iconoImagen = itemVista.findViewById(R.id.iconoImageView);
            nombreProducto = itemVista.findViewById(R.id.nombreTextView);
            valorProducto = itemVista.findViewById(R.id.valorTextView);
            estadoProducto = itemVista.findViewById(R.id.estadoTextView);
        }

        void bindData(final Product product){
            iconoImagen.setImageResource(product.getImage());
            nombreProducto.setText(product.getName());
            valorProducto.setText(product.getPrice());
            estadoProducto.setText(product.getState());
        }
    }
}


