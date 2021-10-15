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

import utn.sistema.practica_primer_parcial.clases.TipoUsuario;
import utn.sistema.practica_primer_parcial.clases.Usuario;
import utn.sistema.practica_primer_parcial.clases.UsuarioAdapter;

public class MainActivity extends AppCompatActivity
{
    List<Usuario> usuarios;
    UsuarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.usuarios = new ArrayList<>();
        this.usuarios = this.mockUsuarios();
        this.adapter = new UsuarioAdapter(this.usuarios);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menú principal");
        actionBar.setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = super.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }





    private List<Usuario> mockUsuarios()
    {
        List<Usuario> mockUsuarios = new ArrayList<>();

        mockUsuarios.add(new Usuario("Pepito","SARASA", TipoUsuario.USUARIO));
        mockUsuarios.add(new Usuario("Manuela","SARASA", TipoUsuario.USUARIO));
        mockUsuarios.add(new Usuario("Jose","MELON1235", TipoUsuario.ADMINISTRADOR));
        mockUsuarios.add(new Usuario("Josefina","OBELISCO99", TipoUsuario.USUARIO));
        mockUsuarios.add(new Usuario("Francisco","MosTaZa12", TipoUsuario.ADMINISTRADOR));
        mockUsuarios.add(new Usuario("Hermeneguildo","FONTANARROSA", TipoUsuario.USUARIO));
        mockUsuarios.add(new Usuario("Mustafa","LOSNUEVELADRONES", TipoUsuario.ADMINISTRADOR));
        mockUsuarios.add(new Usuario("Beatriz","LAZARO1235", TipoUsuario.USUARIO));
        mockUsuarios.add(new Usuario("Mirtha","HIGHLANDER99", TipoUsuario.USUARIO));

        return mockUsuarios;
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(MainActivity.this, EditarUsuario.class);
        startActivity(intent);
    }

}