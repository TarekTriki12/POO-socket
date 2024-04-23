import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;  // Import the Scanner class

public class Client {
    static final int port = 2023;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        Socket socket = new Socket(InetAddress.getLocalHost(),port);
        List<Float> moys=new ArrayList<Float>();


        System.out.println("Socket = " + socket);

        BufferedReader plec = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);



        System.out.println("Donner moi le char : ");
        char ch = scanner.next().charAt(0);
        pred.println(ch);


        String  res= plec.readLine();
        System.out.println(res);
        plec.close();
        pred.close();
        socket.close();
    }
}
