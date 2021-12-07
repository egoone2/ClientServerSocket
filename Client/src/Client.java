import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try(Socket socket = new Socket("127.0.0.1",2000);
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()));
            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));) {


            System.out.println("Connected to Server");
            String cityRequest = reader1.readLine();
            writer.write(cityRequest);
            writer.newLine();
            writer.flush();


            String response = reader.readLine();
            System.out.println(response);
            response = reader.readLine();
            System.out.println(response);
            response = reader.readLine();
            System.out.println(response);
            response = reader.readLine();
            System.out.println(response);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
