
package urls.uris;

import java.net.*;

public class protocolTester {

    public static void main(String[] args) {
        testProtocol("http://www.adc.org");
        testProtocol("https://www.amazon.com/exec/obidos/");
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");
        testProtocol("mailto:elharo@ibiblio.org");
        testProtocol("telnet://dibner.poly.edu/");
        testProtocol("file:///etc/passwd");
        testProtocol("gopher://gopher.anc.org.za/");
    }

    private static void testProtocol(String url) {
        try {
            @SuppressWarnings("deprecation")
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");
        } catch (MalformedURLException ex) {
            String protocol = url.substring(0, url.indexOf(':'));
            System.out.println(protocol + " is not supported");
        }

    }
}