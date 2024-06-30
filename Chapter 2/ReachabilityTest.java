import java.io.IOException;
import java.net.*;

public class ReachabilityTest {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(" java ReachabilityTest");
            return;
        }

        String host = args[0];
        int timeout = Integer.parseInt(args[1]);

        try {
            InetAddress address = InetAddress.getByName("www.google.org");
            boolean reachable = address.isReachable(timeout);

            if (reachable) {
                System.out.println("The host " + host + " is reachable.");
            } else {
                System.out.println("The host " + host + " is not reachable.");
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + host);
        } catch (IOException e) {
            System.err.println("Error checking reachability: " + e.getMessage());
        }
    }
}
