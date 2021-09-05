package utn.sistema.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.logging.Logger;

import utn.sistema.formulario.clases.Persona;
import utn.sistema.formulario.listeners.ClickBoton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void addListenerOnButton()
    {
        Button btnDisplay = (Button) findViewById(R.id.btnGuardar);
        View.OnClickListener onClickListener = new ClickBoton(this);

        btnDisplay.setOnClickListener(onClickListener);
    }
}