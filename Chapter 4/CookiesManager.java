
import java.net.*;
import java.util.List;

public class CookiesManager {
    public static void main(String[] args) {
        CookiesManager cookie = new CookiesManager();
        CookieStore cookies = cookie.getCookieStore();
        HttpCookie cookieA = new HttpCookie("First", "1");
        HttpCookie cookieB = new HttpCookie("Second", "2");
        URI uri = URI.create("https://eiccollege.edu.np/");
        cookies.add(uri, cookieA);
        cookies.add(null, cookieB);

        System.out.println("Cookie Successfully added.");

        List cookiesWithURI = cookies.get(uri);
        System.out.println("Cookies with uri:" + cookiesWithURI + "\n");

        List cookieList = cookies.getCookies();
        System.out.println("Cookies:" + cookieList + "\n");

        List uriList = cookies.getURIs();
        System.out.println("URIs List:" + uriList);

        System.out.println("Removal of cookie:" + cookies.remove(uri, cookieA));

        List rcookieList = cookies.getCookies();
        System.out.println("Remaining Cookies:" + rcookieList + "\n");

        System.out.println("Removal of cookie:" + cookies.removeAll());

        List ecookieList = cookies.getCookies();
        System.out.println("Empty Cookie Store:" + ecookieList + "\n");
    }

    private CookieStore getCookieStore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCookieStore'");
    }

}
