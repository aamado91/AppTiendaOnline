package com.ucompensar.apptiendaonline.ui.productos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ucompensar.apptiendaonline.R;

import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder> {
    private List<Producto> listaProductos;

    public ProductosAdapter(List<Producto> listaProductos){
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

    public void serItems(List<Producto> productos){
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

        void bindData(final Producto producto){
            iconoImagen.setImageResource(producto.getImagen());
            nombreProducto.setText(producto.getNombre());
            valorProducto.setText(producto.getValor());
            estadoProducto.setText(producto.getEstado());
        }
    }
}


