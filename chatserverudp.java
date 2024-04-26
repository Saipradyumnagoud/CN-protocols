import java.net.*;

public class chatserverudp {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876); 
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            
            System.out.println("Server started...");
            
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientIPAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                
                System.out.println("Message from client: " + clientMessage);
                String replyMessage = "Echo: " + clientMessage;
                sendData = replyMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIPAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
