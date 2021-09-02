package utn.sistema.claseuno2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Se configura para poder acceder a los elementos del Content View
        setContentView(R.layout.activity_main);

        /*TextView tvSaludo = super.findViewById(R.id.txtSaludo);
        tvSaludo.setText("Hola Pepito");

        EditText etTexto = super.findViewById(R.id.inputTxt);
        etTexto.setText("Escriba un texto");*/

        Button boton = super.findViewById(R.id.btn);
        View.OnClickListener onClickListener = new ClickBoton(this);
        boton.setOnClickListener(onClickListener);
    }

}