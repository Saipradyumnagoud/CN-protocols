import java.io.*;
import java.net.*;

public class chatclienttcp {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000); 
            BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
            OutputStream ostream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(ostream, true);
            InputStream istream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(istream));
            System.out.println("Start chitchat type and press enter key to continue");
            String receiveMessage, sendMessage;
            while (true) {
                System.out.print("Client: ");
                sendMessage = keyRead.readLine();
                out.println(sendMessage);
                out.flush();

                if ((receiveMessage = in.readLine()) != null) {
                    System.out.println("Server: " + receiveMessage);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
