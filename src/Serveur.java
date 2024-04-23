import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Serveur {

    final static int port = 3030;

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
            String moy = plec.readLine();
            Float intMoy = Float.valueOf(moy);
            moyss.add(intMoy);
            if(moyss.size() == 10) break;
        }
        System.out.println(moyss);
        Float max = Collections.max(moyss);
        Float min = Collections.min(moyss);
        Float sum = (float) 0;
        for (Float num : moyss) {
            sum += num;
        }
        Float avrage = sum / moyss.size();
        System.out.println(min);
        System.out.println(max);
        System.out.println(avrage);
        pred.println("max : " + Float.toString(max) + " min: " + Float.toString(min) +" avrage: "+ Float.toString(avrage) );


        plec.close();
        pred.close();
        soc.close();

    }
}
