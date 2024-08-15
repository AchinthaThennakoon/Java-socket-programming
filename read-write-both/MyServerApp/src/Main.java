import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();

            String input = "";
            String output = "";

            DataInputStream inputStream = new DataInputStream(s.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            while (!input.equals("stop")){
                input = inputStream.readUTF();
                System.out.println("client :"+ input);

                output = br.readLine();
                outputStream.writeUTF(output);

                outputStream.flush();
            }

            inputStream.close();
            outputStream.close();
            s.close();
            ss.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}