import java.net.*;

public class chatclientudp {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverIPAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            
            while (true) {
                String message = "Hello from client";
                sendData = message.getBytes();
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, 9876);
                clientSocket.send(sendPacket);
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String serverReply = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Response from server: " + serverReply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
