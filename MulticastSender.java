import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
    public static void main(String[] args) {
        MulticastSocket socket = null;
        try {
            // The multicast IP address to send data to
            InetAddress group = InetAddress.getByName("224.0.0.1");

            // Create a MulticastSocket
            socket = new MulticastSocket();

            // Message to send
            String message = "Hello, multicast world!";
            byte[] buffer = message.getBytes();

            // Create a DatagramPacket
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 5000);

            // Send the packet to the multicast group
            socket.send(packet);
            System.out.println("Multicast message sent: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
