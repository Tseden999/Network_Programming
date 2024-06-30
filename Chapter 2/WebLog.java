
import java.net.*;
import java.io.*;

public class WebLog {
    public static void main(String[] args) {
        try (
                FileInputStream file = new FileInputStream("Desktop/Network Programming/Comparison.java");
                Reader in = new InputStreamReader(file);
                BufferReader bin = new BufferReader(in);) {

            for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);

                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + theRest);
                } catch (UnknownHostException e) {
                    System.out.println(entry);
                }
            }
        }

        catch (IOException e) {
            System.out.println("Exception" + e);
        }

    }
}