import java.io.*;
import java.net.*;

public class DateTimeClienttcp {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234); 
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String dateTime = in.readLine();
            System.out.println("Server Date and Time: " + dateTime);

            in.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
