package utn.sistema.parcialUnoLabV.clases;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import utn.sistema.parcialUnoLabV.Objeto;

public class Vista
{
    private Objeto usuario;
    Activity activity;
    Controlador controlador;
    EditText edNombre;
    EditText edContrasenia;
    EditText edConfirmacion;
    RadioGroup radioGroup;

    public Vista(Objeto usuario, Activity activity)
    {
        this.usuario = usuario;
        this.activity = activity;
    }

    public void cargarModelo()
    {
        /*
        this.usuario.setNombre(this.edNombre.getText().toString());
        this.usuario.setContrasenia(this.edContrasenia.getText().toString());
        int radioSeleccionado = this.radioGroup.getCheckedRadioButtonId();
        TipoObjeto tipo = TipoObjeto.valueOf(parseEnum(((RadioButton) this.activity.findViewById(radioSeleccionado)).getText().toString()));
        this.usuario.setTipoObjeto(tipo);
        Log.d("Detalle Objeto", this.usuario.toString());

         */
    }

    public void cargarElementos()
    {
        /*
        this.edNombre = this.activity.findViewById(R.id.edNombre);
        this.edContrasenia = this.activity.findViewById(R.id.edContrasenia);
        this.edConfirmacion = this.activity.findViewById(R.id.edConfirmacion);
        // Obtengo valor del radiobutton obteniendo primero el radio group
        this.radioGroup = this.activity.findViewById(R.id.radioPerfil);
        Button btn = activity.findViewById(R.id.btnGuardar);
        btn.setOnClickListener(this.controlador);

         */
    }

    public void mostrarModelo()
    {
        /*
        this.edNombre.setText(this.usuario.getNombre());
        this.edContrasenia.setText(this.usuario.getContrasenia());
        RadioButton radioButtonObjeto = this.activity.findViewById(R.id.radioObjeto);
        RadioButton radioButtonAdmin = this.activity.findViewById(R.id.radioAdmin);
        if(radioButtonObjeto.getText().toString().equals(this.usuario.getTipoObjeto()))
        {
            radioButtonObjeto.setChecked(true);
        }
        else
        {
            radioButtonAdmin.setChecked(true);
        }

         */
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
            case "Objeto" :
            case "User" :
                return "USUARIO";
            case "Administrador":
            case "Admin" :
                return "ADMINISTRADOR";
        }
        return "";
    }
}
