package utn.sistema.parcialUnoLabV;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import utn.sistema.parcialUnoLabV.clases.Controlador;

public class MainActivity extends AppCompatActivity
{
    public static final int OBJETOS = 1;
    public static final int IMAGEN = 2;
    List<Objeto> personas;
    ObjetoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menú principal");
        actionBar.setDisplayHomeAsUpEnabled(true);

        this.adapter = new ObjetoAdapter(Controlador.getInstance().getObjetos(), this);

        RecyclerView recyclerView = super.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}