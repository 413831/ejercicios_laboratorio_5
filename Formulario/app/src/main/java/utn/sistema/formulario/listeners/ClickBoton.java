package utn.sistema.formulario.listeners;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import utn.sistema.formulario.R;
import utn.sistema.formulario.clases.Persona;

public class ClickBoton implements View.OnClickListener
{
    private Activity activity;

    public ClickBoton(Activity activity)
    {
        this.activity = activity;
    }

    @Override
    public void onClick(View view)
    {
        // Nombre
        EditText inputNombre = this.activity.findViewById(R.id.editNombre);
        // Apellido
        EditText inputApellido = this.activity.findViewById(R.id.editApellido);
        // DNI
        EditText inputDni = this.activity.findViewById(R.id.editDni);
        // Sexo
        RadioGroup radioSexo = this.activity.findViewById(R.id.radioSexo);
        int selectedRadio = radioSexo.getCheckedRadioButtonId();
        RadioButton radioButton = this.activity.findViewById(selectedRadio);

        Persona persona = new Persona(inputNombre.getText().toString(),
                                        inputApellido.getText().toString(),
                                        inputDni.getText().toString(),
                                        radioButton.getText().toString());

        Log.d("click",persona.toString());
    }
}
