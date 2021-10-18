package utn.sistema.practica_primer_parcial.listeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import utn.sistema.practica_primer_parcial.EditarUsuario;
import utn.sistema.practica_primer_parcial.MainActivity;

public class ClickNavegar implements View.OnClickListener
{
    Activity activity;
    int indice;

    public ClickNavegar(Activity activity, int indice)
    {
        this.activity = activity;
        this.indice = indice;
    }

    @Override
    public void onClick(View v)
    {
        // Se navega hacia menu de EditarUsuario
        Intent intent = new Intent(this.activity, EditarUsuario.class);

        intent.putExtra("index", this.indice);
        this.activity.startActivity(intent);
    }
}
