import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9876); // Server socket binds to port 9876
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {
                // Receive packet from client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received number: " + received);

                // Parse the received number
                int number = Integer.parseInt(received.trim());

                // Determine if the number is even or odd
                String response;
                if (number % 2 == 0) {
                    response = "Even";
                } else {
                    response = "Odd";
                }

                // Send response back to client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);

                System.out.println("Sent response: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
