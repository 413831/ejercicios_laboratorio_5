package utn.sistema.practica_primer_parcial.clases;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import utn.sistema.practica_primer_parcial.R;
import utn.sistema.practica_primer_parcial.listeners.ClickNavegar;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioViewholder>
{
    List<Usuario> usuarios;
    Activity activity;

    public UsuarioAdapter(List<Usuario> usuarios, Activity activity)
    {
        this.usuarios = usuarios;
        this.activity = activity;
    }

    @NonNull
    @Override
    public UsuarioViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usuario, parent,false);
        return new UsuarioViewholder(view);
    }

    /**
     * Renderiza cada uno de los elementos de una lista
     * @param holder Elemento con informacion del model a mostrar
     * @param position Posicion del elemento en el listado
     */
    @Override
    public void onBindViewHolder(@NonNull UsuarioViewholder holder, int position)
    {
        Usuario usuario = this.usuarios.get(position);

        Log.d("POSITION", String.valueOf(position));
        // Se agrega handler para navegar al menu desde xml de Usuario
        View.OnClickListener onClickListener = new ClickNavegar(this.activity, position);
        holder.btnGuardar.setOnClickListener(onClickListener);
        holder.txtNombre.setText(usuario.getNombre());
        holder.txtPerfil.setText(usuario.getTipoUsuario());
    }

    @Override
    public int getItemCount()
    {
        return this.usuarios.size();
    }
}
