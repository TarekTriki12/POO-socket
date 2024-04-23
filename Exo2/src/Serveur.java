import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Serveur {

    final static int port = 2023;

    public static void main(String[] args) throws Exception {
        List<Float> moyss=new ArrayList<Float>();

        ServerSocket s= new ServerSocket(port);
        Socket soc = s.accept();

        BufferedReader plec = new BufferedReader(
                new InputStreamReader((soc.getInputStream()))
        );

        PrintWriter pred = new PrintWriter(
                new OutputStreamWriter(soc.getOutputStream()),true
        );


        while (true){
            String lettre = plec.readLine();
            switch(lettre) {
                case "a":
                    pred.println(".-");
                    break;
                case "b":
                    pred.println("-...");
                    break;
                case "c":
                    pred.println("-.-.");
                    break;
                default:
                    pred.println("Error");
                    break;
            }
            break;
        }
        plec.close();
        pred.close();
        soc.close();

    }
}
