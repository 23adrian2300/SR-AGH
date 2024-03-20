import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class JavaUdpServer {

    public static void main(String args[]) {
        System.out.println("JAVA UDP SERVER");

        DatagramSocket socket = null;
        int portNumber = 9008;
        byte[] sendBuffer;

        try {
            socket = new DatagramSocket(portNumber);
            byte[] receiveBuffer = new byte[1024];

            while (true) {
                Arrays.fill(receiveBuffer, (byte) 0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                // String msg = new String(receivePacket.getData());
                int receivedNumber = ByteBuffer.wrap(receiveBuffer).order(ByteOrder.LITTLE_ENDIAN).getInt();
                System.out.println("received msg: " + receivedNumber);
                receivedNumber++;

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPortNumber = receivePacket.getPort();
                sendBuffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(receivedNumber).array();
                DatagramPacket packetSent = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress,
                        clientPortNumber);
                socket.send(packetSent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
