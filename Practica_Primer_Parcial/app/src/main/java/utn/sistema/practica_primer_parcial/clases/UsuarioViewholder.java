package utn.sistema.practica_primer_parcial.clases;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import utn.sistema.practica_primer_parcial.R;

public class UsuarioViewholder extends RecyclerView.ViewHolder
{
    TextView txtNombre;
    TextView txtPerfil;
    Button btnGuardar;

    public UsuarioViewholder(@NonNull View itemView)
    {
        super(itemView);
        this.btnGuardar = itemView.findViewById(R.id.btnEditar);
        this.txtNombre = itemView.findViewById(R.id.txtNombre);
        this.txtPerfil = itemView.findViewById(R.id.txtPerfil);
    }
}
