package utn.sistema.mvc;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Vista
{
    Modelo modelo;
    Activity activity;
    EditText edNombre;
    EditText edApellido;
    EditText edDNI;
    TextView txtNombre;
    TextView txtApellido;
    TextView txtDni;
    Controlador controlador;

    public Vista(Modelo modelo, Activity activity)
    {
        this.modelo = modelo;
        this.activity = activity;
    }

    public void cargarElementos()
    {
        this.edNombre = activity.findViewById(R.id.edNombre);
        Button btn = activity.findViewById(R.id.btnGuardar);
        btn.setOnClickListener(this.controlador);
    }

    public void cargarModelo()
    {
        this.modelo.setNombre(this.edNombre.getText().toString());
    }

    public void mostrarModelo()
    {
        this.edNombre.setText(this.modelo.getNombre());
    }

    public void mostrarMensaje(String mensaje)
    {
        Toast.makeText(this.activity,mensaje, Toast.LENGTH_SHORT).show();
    }

    public void setControlador(Controlador controlador)
    {
        this.controlador = controlador;
        this.cargarElementos();
    }
}
