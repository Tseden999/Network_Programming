package urls.uris;

import java.net.*;

public class URLsplitter {

    @SuppressWarnings("deprecation")
    public static void main(String args[]) {

        try {
            URL url = new URL("https://eiccollege.edu.np");
            System.out.println("The URL is " + url);
            System.out.println("The scheme is " + url.getProtocol());
            System.out.println("The user info is " + url.getUserInfo());
            String host = url.getHost();
            if (host != null) {
                int atSign = host.indexOf('@');
                if (atSign != -1) {
                    host = host.substring(atSign + 1);
                }
                System.out.println("The host is " + host);
            } else {
                System.out.println("The host is null.");
            }
            System.out.println("The port is " + url.getPort());
            System.out.println("The path is " + url.getPath());
            System.out.println("The ref is " + url.getRef());
            System.out.println("The query string is " + url.getQuery());
        } catch (MalformedURLException ex) {
            System.err.println(" Given URL is not a URL.");
        }
        System.out.println();

    }

}
