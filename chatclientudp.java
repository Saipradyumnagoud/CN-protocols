
import java.io.*;
import java.net.*;

public class chatclientudp {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(6667);
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            DatagramPacket sendPacket;
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            String msg;

            while(true) {
                System.out.print("Client : ");
                msg = stdin.readLine();
                sendData = msg.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), 6666);
                ds.send(sendPacket);
                if(msg.equalsIgnoreCase("end")){
                    break;
                }
                ds.receive(receivePacket);
                msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server : " + msg);
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}