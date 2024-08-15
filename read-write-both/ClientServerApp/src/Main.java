import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",6666);

            String input = "";
            String output = "";

            DataInputStream inputStream = new DataInputStream(s.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            while (!input.equals("stop")){
                output = br.readLine();
                outputStream.writeUTF(output);
                outputStream.flush();

                input = inputStream.readUTF();
                System.out.println("server :"+ input);

            }

            inputStream.close();
            outputStream.close();
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}