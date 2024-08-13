import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) {
        MulticastSocket socket = null;
        try {
            // The multicast IP address to join (e.g., 224.0.0.1 is a common multicast
            // address)
            InetAddress group = InetAddress.getByName("224.0.0.1");

            // Create a MulticastSocket bound to a specific port (e.g., 5000)
            socket = new MulticastSocket(5000);

            // Join the multicast group
            socket.joinGroup(group);

            System.out.println("Joined multicast group at " + group.getHostAddress() + " on port 5000");
            System.out.println("Waiting for multicast data...");

            // Prepare to receive data
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                // Display received data
                String receivedData = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received multicast data: " + receivedData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    // Leave the multicast group
                    socket.leaveGroup(InetAddress.getByName("224.0.0.1"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket.close();
            }
        }
    }
}
