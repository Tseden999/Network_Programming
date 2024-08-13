import java.nio.ByteBuffer;

public class BufferFillDrain {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10); // Allocate a buffer with capacity of 10 bytes

        // Fill the buffer with data (Filling Phase)
        System.out.println("Filling buffer...");
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) (i + 1)); // Put byte values 1, 2, 3,... into the buffer
            System.out.println("Filled: " + (i + 1));
        }

        // Switch to reading mode by flipping the buffer
        buffer.flip();

        // Drain the buffer (Draining Phase)
        System.out.println("\nDraining buffer...");
        while (buffer.hasRemaining()) {
            byte b = buffer.get(); // Get each byte from the buffer
            System.out.println("Drained: " + b);
        }

        // Rewind the buffer to prepare for another drain, if needed
        buffer.rewind();
        System.out.println("\nBuffer rewound and ready to be drained again...");
        while (buffer.hasRemaining()) {
            byte b = buffer.get(); // Get each byte again
            System.out.println("Drained: " + b);
        }
    }
}
