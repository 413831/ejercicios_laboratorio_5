package utn.sistema.recyclerview;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnection
{
    public String obtenerPersonas(String urlString)
    {
        String personas = "";

        try
        {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int response = urlConnection.getResponseCode();

            if(response == 200)
            {
                InputStream inputStream = urlConnection.getInputStream();
                ByteArrayOutputStream byteResponse = new ByteArrayOutputStream();
                byte[] buffer = new byte[1000];
                int length = 0;

                while((length = inputStream.read(buffer)) != -1)
                {
                    byteResponse.write(buffer, 0 , length);
                }
                inputStream.close();
                return new String(byteResponse.toByteArray());
            }
            else
            {
                throw new RuntimeException("Error");
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return personas;
    }

    public byte[] obtenerImagen(String urlString)
    {
        try
        {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int response = urlConnection.getResponseCode();

            if(response == 200)
            {
                InputStream inputStream = urlConnection.getInputStream();
                ByteArrayOutputStream byteResponse = new ByteArrayOutputStream();
                byte[] buffer = new byte[1000];
                int length = 0;

                while((length = inputStream.read(buffer)) != -1)
                {
                    byteResponse.write(buffer, 0 , length);
                }
                inputStream.close();
                return byteResponse.toByteArray();
            }
            else
            {
                throw new RuntimeException("Error");
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
