package com.ucompensar.apptiendaonline.ui.compras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ucompensar.apptiendaonline.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ComprasAdapter extends RecyclerView.Adapter<ComprasAdapter.CompraViewHolder> {

    private List<ProductoCarrito> listaProductosCarrito;

    public ComprasAdapter(List<ProductoCarrito> listaProductosCarrito){
        this.listaProductosCarrito = listaProductosCarrito;
    }

    @Override
    public ComprasAdapter.CompraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_carrito, null, false);
        return new CompraViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(CompraViewHolder holder, int position) {
        holder.bindData(listaProductosCarrito.get(position));
    }

    @Override
    public int getItemCount() {
        return listaProductosCarrito.size();
    }

    public void serItems(List<ProductoCarrito> productosCarrito){
        this.listaProductosCarrito = productosCarrito;
    }

    public class CompraViewHolder extends RecyclerView.ViewHolder {
        ImageView iconoImagen;
        TextView nombreProducto, valorProducto, valorTotalProducto, cantidadProducto;
        public CompraViewHolder(View itemVista){
            super(itemVista);
            iconoImagen = itemVista.findViewById(R.id.iconoItemCarrito);
            nombreProducto = itemVista.findViewById(R.id.itemNombreCarrito);
            valorProducto = itemVista.findViewById(R.id.itemValorCarrito);
            valorTotalProducto = itemVista.findViewById(R.id.itemValorTotalCarrito);
            cantidadProducto = itemVista.findViewById(R.id.itemCantidad);
        }

        void bindData(final ProductoCarrito item){

            Locale localizacion = new Locale ("es", "CO");
            NumberFormat formatoNumero = NumberFormat.getInstance (localizacion);
            String strValorProducto = formatoNumero.format(Integer.parseInt(item.producto.getValor()));
            String strValorTotalProducto = formatoNumero.format(Integer.parseInt(item.producto.getValor()) * item.cantidad);

            iconoImagen.setImageResource(item.producto.getImagen());
            nombreProducto.setText(item.producto.getNombre());
            valorProducto.setText("$ " + strValorProducto);
            valorTotalProducto.setText("$ " + strValorTotalProducto);
            cantidadProducto.setText(String.valueOf(item.cantidad));
        }
    }
}


