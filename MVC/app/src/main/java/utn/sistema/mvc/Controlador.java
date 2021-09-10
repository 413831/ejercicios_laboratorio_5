package utn.sistema.mvc;

import android.app.Activity;
import android.util.Log;
import android.view.View;

public class Controlador implements View.OnClickListener
{
    private Modelo modelo;
    private Vista vista;
    private Activity activity;

    public Controlador(Modelo modelo, Vista vista, Activity activity)
    {
        this.modelo = modelo;
        this.vista = vista;
        this.activity = activity;
    }

    public boolean validarDatos()
    {
        if(this.modelo.getNombre() != null && !this.modelo.getNombre().isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void onClick(View view)
    {
        this.vista.cargarModelo();
        if(this.validarDatos())
        {
            Log.d("Modelo",this.modelo.toString());
            this.vista.mostrarMensaje(this.activity.getString(R.string.error));
        }
        else
        {
            Log.d("Error", "datos incompletos");
        }
    }
}
