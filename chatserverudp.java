import java.net.*;
import java.io.*;

public class chatserverudp {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(6666);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            DatagramPacket receivePacket;
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            DatagramPacket sendPacket;
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            String msg;

            while(true) {
                ds.receive(receivePacket);
                msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client : " + msg);
                System.out.print("Server : ");
                msg = stdin.readLine();
                sendData = msg.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), 6667);
                ds.send(sendPacket);
                if(msg.equalsIgnoreCase("end")){
                    break;
                }
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
