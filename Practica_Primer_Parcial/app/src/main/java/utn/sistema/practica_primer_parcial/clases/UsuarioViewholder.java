package utn.sistema.practica_primer_parcial.clases;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import utn.sistema.practica_primer_parcial.R;

public class UsuarioViewholder extends RecyclerView.ViewHolder
{
    TextView txtNombre;
    TextView txtPerfil;

    public UsuarioViewholder(@NonNull View itemView)
    {
        super(itemView);
        this.txtNombre = itemView.findViewById(R.id.txtNombre);
        this.txtPerfil = itemView.findViewById(R.id.txtPerfil);
    }
}
