import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;  // Import the Scanner class

public class Client {
    static final int port = 3030;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        Socket socket = new Socket(InetAddress.getLocalHost(),port);
        List<Float> moys=new ArrayList<Float>();


        System.out.println("Socket = " + socket);

        BufferedReader plec = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);



        String str = "bonjour";



        for (int i=1 ; i<=10 ;i++){
            System.out.println("Le moyenne de l'etudiant "+i+ " : ");
            String numbersAsString = scanner.nextLine();
            pred.println(numbersAsString);
        }

        String  s= plec.readLine(); System.out.println(s);
        plec.close();
        pred.close();
        socket.close();
    }
}
