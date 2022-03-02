import java.net.*;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class Teste {

    public static void main(String [] args) {
        new Teste().executar();
    }
    
    public void executar() {

        HttpsURLConnection urlConnection = null;
        try {
            URL url = new URL("https://fernandoanselmo.blogspot.com/feeds/posts/default");
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);
            InputStream in = urlConnection.getInputStream();
            System.out.println(in);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        System.out.println("Aqui");
    }
    
}
