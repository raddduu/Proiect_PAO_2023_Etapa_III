package Model.Persoana.Bucatar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class BucatarSingleton {
    private static BucatarSingleton instance = null;
    private ArrayList<Bucatar> bucatari = new ArrayList<Bucatar>();

    public static BucatarSingleton getInstance()
    {
        if (instance == null)
            instance = new BucatarSingleton();
        return instance;
    }

    public static void setInstance(BucatarSingleton instance) {
        BucatarSingleton.instance = instance;
    }


    public ArrayList<Bucatar> citesteCSV() {
        String path = "Data/Bucatari.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            if (line == null) {
                System.out.println("Nu exista bucatari!");
            } else {
                while (line != null) {
                    String[] bucatar = line.split(",");
                    var bucatarNou = new Bucatar(
                            Integer.parseInt(bucatar[0]), //id
                            bucatar[1], //prenume
                            bucatar[2], //nume
                            bucatar[3], //gen
                            Integer.parseInt(bucatar[4]), //an
                            Integer.parseInt(bucatar[5]), //luna
                            Integer.parseInt(bucatar[6]), //zi
                            Integer.parseInt(bucatar[7]), //ani_exp
                            bucatar[8], //specializare
                            Integer.parseInt(bucatar[9]), //rang
                            Integer.parseInt(bucatar[10]) //id_restaurant
                    );
                    bucatari.add(bucatarNou);
                    line = br.readLine();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return bucatari;
    }

    public void scrieCSV(ArrayList<Bucatar> bucatari){
        try{
            var writer = new FileWriter("Data/DisplayBucatari.csv");
            for(var bucatar : bucatari){
                writer.write(bucatar.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
