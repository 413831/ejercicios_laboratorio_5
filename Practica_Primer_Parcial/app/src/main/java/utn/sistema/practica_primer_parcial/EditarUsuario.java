package utn.sistema.practica_primer_parcial;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import utn.sistema.practica_primer_parcial.clases.Controlador;
import utn.sistema.practica_primer_parcial.clases.Usuario;
import utn.sistema.practica_primer_parcial.clases.Vista;
import utn.sistema.practica_primer_parcial.listeners.ClickGuardar;

public class EditarUsuario extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        int indice = getIntent().getExtras().getInt("index");


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Editar usuario");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        // Se vuelve al menu principal desde ActionBar
        if(android.R.id.home == item.getItemId())
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        int indice = getIntent().getExtras().getInt("index");
        Log.d("INDEX", String.valueOf(indice));
        Usuario usuario = Controlador.getInstance().getUsuario(indice);
        Log.d("USUARIO", usuario.toString());
        Vista vista = new Vista(usuario,this);
        Controlador.getInstance().setIndice(indice);
        Controlador.getInstance().setUsuario(usuario);
        Controlador.getInstance().setActivity(this);
        Controlador.getInstance().setVista(vista);

        vista.setControlador(Controlador.getInstance());
    }
}
