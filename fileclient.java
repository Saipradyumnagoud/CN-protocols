import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class fileclient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);

            OutputStream outputStream = socket.getOutputStream();

            FileInputStream fileInputStream = new FileInputStream("abc.txt");

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            fileInputStream.close();
            outputStream.close();
            socket.close();

            System.out.println("File sent successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
