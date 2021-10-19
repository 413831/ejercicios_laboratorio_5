package utn.sistema.parcialUnoLabV;

import android.app.Activity;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ObjetoAdapter extends RecyclerView.Adapter<ObjetoViewHolder>
{
    List<Objeto> lista;
    Activity activity;

    public ObjetoAdapter(List<Objeto> lista)
    {
        this.lista = lista;
    }

    public ObjetoAdapter(List<Objeto> lista, Activity activity)
    {
        this.lista = lista;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ObjetoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.persona, parent, false);
        //return new PersonaViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ObjetoViewHolder holder, int position)
    {
        //Persona persona = this.personas.get(position);

        //holder.txtNombre.setText(persona.getNombre());
        //holder.txtApellido.setText(persona.getApellido());
    }

    @Override
    public int getItemCount()
    {
        return this.lista.size();
    }
}
