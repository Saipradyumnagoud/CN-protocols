import java.io.*;

public class subnetmask {
    public static void main(String[] args) 
    throws IOException 
    {
        System.out.println("Enter IP: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();

        String[] ipParts = ip.split("\\.");
        int firstOctet = Integer.parseInt(ipParts[0]);

        String mask = null;
        if (firstOctet >= 0 && firstOctet <= 127) {
            mask = "255.0.0.0";
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            mask = "255.255.0.0";
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            mask = "255.255.255.0";
        }

        System.out.println("MASK :\n" + mask);

        if (mask != null) { 
            String[] maskParts = mask.split("\\.");
            StringBuilder networkAddr = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                int x = Integer.parseInt(ipParts[i]);
                int y = Integer.parseInt(maskParts[i]);
                int z = x & y;
                networkAddr.append(z).append(".");
            }

            System.out.println("Network Address:\n" + networkAddr.deleteCharAt(networkAddr.length() - 1));
        } else {
            System.out.println("Invalid IP address.");
        }
    }
}
