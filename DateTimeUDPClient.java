import java.io.*;
import java.net.*;

public class DateTimeUDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket(); 
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 1234;
            String request = "DateTimeRequest";
            byte[] sendData = request.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String dateTime = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server Date and Time: " + dateTime);
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

