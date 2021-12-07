import java.io.*;
import java.net.*;



public class Server {

    public static void main(String[] args) {




        try (ServerSocket serverSocket = new ServerSocket(2000);)  {

            System.out.println("Server started");
            while (true) {
            try (Socket socket = serverSocket.accept();
                 BufferedWriter writer =
                         new BufferedWriter(
                                 new OutputStreamWriter(
                                         socket.getOutputStream()));) {
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));

                System.out.println("Client connected");
                WeatherApp app = new WeatherApp();

                String request = reader.readLine();
                String response = app.getWeather(request);
                writer.write(response);
                writer.write(response);
                writer.write(response);
                writer.write(response);

                writer.newLine();
                writer.flush();
              }
        }   }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
