package Model.Oras;

import Model.Oras.Oras;
import Model.Oras.OrasSingleton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrasSingleton {
    private static OrasSingleton instance = null;
    private ArrayList<Oras> orase = new ArrayList<Oras>();

    public static OrasSingleton getInstance()
    {
        if (instance == null)
            instance = new OrasSingleton();
        return instance;
    }

    public static void setInstance(OrasSingleton instance) {
        OrasSingleton.instance = instance;
    }


    public ArrayList<Oras> citesteCSV() {
        String path = "Data/orase.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            if (line == null) {
                System.out.println("Nu exista orase!");
            } else {
                while (line != null) {
                    String[] Oras = line.split(",");
                    var LocatieNou = new Oras(
                            Integer.parseInt(Oras[0]), //id
                            Oras[1], //nume
                            Integer.parseInt(Oras[2]) //numar_locuitori
                    );
                    orase.add(LocatieNou);
                    line = br.readLine();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return orase;
    }

    public void scrieCSV(ArrayList<Oras> orase){
        try{
            var writer = new FileWriter("Data/DisplayLocatii.csv");
            for(var Oras : orase){
                writer.write(Oras.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
