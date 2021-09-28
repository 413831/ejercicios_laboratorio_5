package utn.sistema.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder
{
    TextView txtNombre;
    TextView txtApellido;

    public PersonaViewHolder(@NonNull View itemView) {
        super(itemView);
        this.txtNombre = itemView.findViewById(R.id.txtNombre);
        this.txtApellido = itemView.findViewById(R.id.txtApellido);
    }
}
