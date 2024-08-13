import java.net.*;
import java.util.List;

public class CookiesManager {
    public static void main(String[] args) {
        // Create an instance of CookiesManager
        CookiesManager cookieManager = new CookiesManager();

        // Get the cookie store from the cookie manager
        CookieStore cookies = cookieManager.getCookieStore();

        // Create two cookies
        HttpCookie cookieA = new HttpCookie("First", "1");
        HttpCookie cookieB = new HttpCookie("Second", "2");

        // Specify a URI
        URI uri = URI.create("https://eiccollege.edu.np/");

        // Add cookies to the cookie store
        cookies.add(uri, cookieA);
        cookies.add(null, cookieB);

        System.out.println("Cookie successfully added.");

        // Retrieve cookies associated with the specific URI
        List<HttpCookie> cookiesWithURI = cookies.get(uri);
        System.out.println("Cookies with URI: " + cookiesWithURI + "\n");

        // Retrieve all cookies in the cookie store
        List<HttpCookie> cookieList = cookies.getCookies();
        System.out.println("All cookies: " + cookieList + "\n");

        // Retrieve all URIs in the cookie store
        List<URI> uriList = cookies.getURIs();
        System.out.println("URI List: " + uriList + "\n");

        // Remove a specific cookie
        boolean removed = cookies.remove(uri, cookieA);
        System.out.println("Removal of cookie 'First': " + removed);

        // Check remaining cookies
        List<HttpCookie> remainingCookies = cookies.getCookies();
        System.out.println("Remaining cookies: " + remainingCookies + "\n");

        // Remove all cookies
        boolean allRemoved = cookies.removeAll();
        System.out.println("All cookies removed: " + allRemoved);

        // Verify the cookie store is empty
        List<HttpCookie> emptyCookieList = cookies.getCookies();
        System.out.println("Empty cookie store: " + emptyCookieList + "\n");
    }

    // Method to get the cookie store using a CookieManager
    private CookieStore getCookieStore() {
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        return cookieManager.getCookieStore();
    }
}
