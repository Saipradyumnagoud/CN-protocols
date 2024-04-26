import java.io.*;
import java.net.*;

public class chatservertcp {
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Server ready");

            Socket socket = serverSocket.accept();
            System.out.println("Connection is successful and waiting for chatting");

            BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
            OutputStream ostream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(ostream, true);
            InputStream istream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(istream));
            String receiveMessage, sendMessage;
            while (true) {
                if ((receiveMessage = in.readLine()) != null) {
                    System.out.println("Client: " + receiveMessage);
                }
                System.out.print("Server: ");
                sendMessage = keyRead.readLine();
                out.println(sendMessage);
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
