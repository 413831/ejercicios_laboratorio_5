package utn.sistema.recyclerview;

import android.util.Log;

public class MiConsulta extends Thread
{
    @Override
    public void run()
    {
        // IP para Localhost
        String url = "http://XXX.XXX.X.X:3000/personas";

        HttpConnection httpConnection = new HttpConnection();
        String s = httpConnection.obtenerPersonas(url);

        Log.d("respuesta",s);
    }
}
