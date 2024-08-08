
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AllHeaders {
    public static void main(String[] args) {
        String url = "https://facebook.com";
        try {
            headerView(url);
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a URL I understand.");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println();
    }

    private static void headerView(String url) throws MalformedURLException, IOException {
        URL u = new URL(url);
        URLConnection uc = u.openConnection();
        for (int i = 1;; i++) {
            String header = uc.getHeaderField(i);
            if (header == null)
                break;
            System.out.println(uc.getHeaderFieldKey(i) + ": " + header);
        }
    }
}