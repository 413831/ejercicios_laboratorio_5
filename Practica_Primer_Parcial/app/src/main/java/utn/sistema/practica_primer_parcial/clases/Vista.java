package utn.sistema.practica_primer_parcial.clases;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Arrays;

import utn.sistema.practica_primer_parcial.R;

public class Vista
{
    private Usuario usuario;
    Activity activity;
    Controlador controlador;
    EditText edNombre;
    EditText edContrasenia;
    EditText edConfirmacion;
    RadioGroup radioGroup;

    public Vista(Usuario usuario, Activity activity)
    {
        this.usuario = usuario;
        this.activity = activity;
    }

    public void cargarModelo()
    {
        this.usuario.setNombre(this.edNombre.getText().toString());
        this.usuario.setContrasenia(this.edContrasenia.getText().toString());
        int radioSeleccionado = this.radioGroup.getCheckedRadioButtonId();
        TipoUsuario tipo = TipoUsuario.valueOf(parseEnum(((RadioButton) this.activity.findViewById(radioSeleccionado)).getText().toString()));
        this.usuario.setTipoUsuario(tipo);
        Log.d("Detalle Usuario", this.usuario.toString());
    }

    public void cargarElementos()
    {
        this.edNombre = this.activity.findViewById(R.id.edNombre);
        this.edContrasenia = this.activity.findViewById(R.id.edContrasenia);
        this.edConfirmacion = this.activity.findViewById(R.id.edConfirmacion);
        // Obtengo valor del radiobutton obteniendo primero el radio group
        this.radioGroup = this.activity.findViewById(R.id.radioPerfil);
        Button btn = activity.findViewById(R.id.btnGuardar);
        btn.setOnClickListener(this.controlador);
    }

    public void mostrarModelo()
    {
        this.edNombre.setText(this.usuario.getNombre());
        this.edContrasenia.setText(this.usuario.getContrasenia());
        RadioButton radioButtonUsuario = this.activity.findViewById(R.id.radioUsuario);
        RadioButton radioButtonAdmin = this.activity.findViewById(R.id.radioAdmin);
        if(radioButtonUsuario.getText().toString().equals(this.usuario.getTipoUsuario()))
        {
            radioButtonUsuario.setChecked(true);
        }
        else
        {
            radioButtonAdmin.setChecked(true);
        }
    }

    public void mostrarMensaje(String mensaje)
    {
        Toast.makeText(this.activity,mensaje, Toast.LENGTH_SHORT).show();
    }

    public void setControlador(Controlador controlador)
    {
        this.controlador = controlador;
        this.cargarElementos();
        this.mostrarModelo();
    }

    private String parseEnum(String value)
    {
        switch (value)
        {
            case "Usuario" :
            case "User" :
                return "USUARIO";
            case "Administrador":
            case "Admin" :
                return "ADMINISTRADOR";
        }
        return "";
    }
}
