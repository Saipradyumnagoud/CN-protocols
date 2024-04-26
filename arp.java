import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class arp {
    public static void main(String[] args) {
        try {
            Scanner console = new Scanner(System.in);
            System.out.print("Enter The system name: ");
            String ipaddr = console.nextLine();
            InetAddress address = InetAddress.getByName(ipaddr);
            System.out.println("address: " + address);
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            if (ni != null) {
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
                    System.out.println("MAC address: ");
                    for (int i = 0; i < mac.length; i++) {
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                    }
                } else {
                    System.out.println("Address does not exist or is not accessible.");
                }
            } else {
                System.out.println("Network interface for the specified address is not found.");
            }
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }
    }
}
