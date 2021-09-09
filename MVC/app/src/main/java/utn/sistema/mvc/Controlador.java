package utn.sistema.mvc;

import android.util.Log;
import android.view.View;

public class Controlador implements View.OnClickListener
{
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista)
    {
        this.modelo = modelo;
        this.vista = vista;
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
            this.vista.mostrarMensaje("Datos modelo");
        }
        else
        {
            Log.d("Error", "datos incompletos");
        }
    }
}
