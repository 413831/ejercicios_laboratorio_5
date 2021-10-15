package utn.sistema.practica_primer_parcial.clases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import utn.sistema.practica_primer_parcial.R;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioViewholder>
{
    List<Usuario> usuarios;

    public UsuarioAdapter(List<Usuario> usuarios)
    {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuarioViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usuario, parent,false);
        return new UsuarioViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewholder holder, int position)
    {
        Usuario usuario = this.usuarios.get(position);

        // Se puede asignar el listener de click
        holder.txtNombre.setText(usuario.getNombre());
        holder.txtPerfil.setText(usuario.getTipoUsuario());
    }

    @Override
    public int getItemCount()
    {
        return this.usuarios.size();
    }
}
