package utn.sistema.parcialUnoLabV.services;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import utn.sistema.parcialUnoLabV.MainActivity;

public class ServicioObjetos extends Thread
{
    Handler handler;
    Boolean bool;

    public ServicioObjetos(Handler handler, Boolean bool)
    {
        this.handler = handler;
        this.bool = bool;
    }

    @Override
    public void run()
    {
        if(this.bool)
        {
            this.getObjetos();
        }
        else
        {
            this.getImagen();
        }
    }

    private void getObjetos()
    {
        // IP para Localhost
        String url = "http:/XXX.XXX.X.X:3000/personas";

        HttpConnection httpConnection = new HttpConnection();
        String s = httpConnection.obtenerElementos(url);
        Log.d("respuesta",s);
        // Comunicacion para leer el mensaje
        Message message = new Message();
        message.obj = s;
        // Se puede configurar una constante para conectar un hilo
        message.arg1 = MainActivity.OBJETOS;
        // Se guarda mensaje dentro del handler
        this.handler.sendMessage(message);
    }

    private void getImagen()
    {
        // El booleano determina si obtener objetos o imagenes
        String urlImagen = "https://static.wikia.nocookie.net/tokyo-ghoul-la/images/2/25/Mascara_de_Ken.jpg/revision/latest?cb=20150807021009&path-prefix=es";

        HttpConnection httpConnection = new HttpConnection();
        byte[] imagen = httpConnection.obtenerImagen(urlImagen);
        Log.d("respuesta",imagen.toString());
        // Comunicacion para leer el mensaje
        Message message = new Message();
        message.obj = imagen;
        // Se puede configurar una constante para conectar un hilo
        message.arg1 = MainActivity.IMAGEN;
        // Se guarda mensaje dentro del handler
        this.handler.sendMessage(message);
    }
}
