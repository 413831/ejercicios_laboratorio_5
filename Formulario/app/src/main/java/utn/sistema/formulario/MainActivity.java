package utn.sistema.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputNombre = super.findViewById(R.id.editNombre);
        EditText inputApellido = super.findViewById(R.id.editApellido);
        EditText inputDni = super.findViewById(R.id.editDni);
        RadioGroup radioSexo = super.findViewById(R.id.radioSexo);


    }
}