package utn.sistema.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaViewHolder>
{
    List<Persona> personas;

    public PersonaAdapter(List<Persona> personas)
    {
        this.personas = personas;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Inflate
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.persona, parent, false);
        return new PersonaViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position)
    {
        Persona persona = this.personas.get(position);

        holder.txtNombre.setText(persona.getNombre());
        holder.txtApellido.setText(persona.getApellido());
    }

    @Override
    public int getItemCount()
    {
        return this.personas.size();
    }
}
