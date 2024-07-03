package urls.uris;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ObjectDownload {
    public static void main(String[] args) {
        download("https://google.com");
    }

    private static void download(String url) {
        try {
            @SuppressWarnings("deprecation")
            URL url1 = new URL(url);
            Object o = url1.getContent();
            System.out.println("I got a " + o.getClass().getName());
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
