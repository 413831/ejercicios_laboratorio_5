package utn.sistema.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Modelo modelo = new Modelo();
        Vista vista = new Vista(modelo, this);
        Controlador controlador = new Controlador(modelo, vista);
        vista.setControlador(controlador);
    }
}