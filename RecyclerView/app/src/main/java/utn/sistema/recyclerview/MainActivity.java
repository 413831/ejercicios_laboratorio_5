package utn.sistema.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("nombre1", "apellido1"));
        personas.add(new Persona("nombre2", "apellido2"));
        personas.add(new Persona("nombre3", "apellido3"));
        personas.add(new Persona("nombre4", "apellido4"));
        personas.add(new Persona("nombre5", "apellido5"));
        personas.add(new Persona("nombre6", "apellido6"));
        personas.add(new Persona("nombre7", "apellido7"));
        personas.add(new Persona("nombre8", "apellido8"));
        personas.add(new Persona("nombre9", "apellido9"));
        personas.add(new Persona("nombre10", "apellido10"));

        PersonaAdapter adapter = new PersonaAdapter(personas);

        RecyclerView recyclerView = super.findViewById(R.id.recyclerview);

        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                                                                            LinearLayoutManager.VERTICAL,
                                                                            false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}