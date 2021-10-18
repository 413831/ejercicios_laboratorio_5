package utn.sistema.practica_primer_parcial;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import utn.sistema.practica_primer_parcial.clases.Controlador;
import utn.sistema.practica_primer_parcial.clases.TipoUsuario;
import utn.sistema.practica_primer_parcial.clases.Usuario;
import utn.sistema.practica_primer_parcial.clases.UsuarioAdapter;

public class MainActivity extends AppCompatActivity
{

    UsuarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menú principal");
        actionBar.setDisplayHomeAsUpEnabled(true);

        this.adapter = new UsuarioAdapter(Controlador.getInstance().getUsuarios(), this);

        RecyclerView recyclerView = super.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.adapter.notifyDataSetChanged();

    }
}