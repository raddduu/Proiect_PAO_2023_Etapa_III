package Model.Locatie;

import Model.Locatie.Locatie;
import Model.Locatie.LocatieSingleton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LocatieSingleton {
    private static LocatieSingleton instance = null;
    private ArrayList<Locatie> locatii = new ArrayList<Locatie>();

    public static LocatieSingleton getInstance()
    {
        if (instance == null)
            instance = new LocatieSingleton();
        return instance;
    }

    public static void setInstance(LocatieSingleton instance) {
        LocatieSingleton.instance = instance;
    }


    public ArrayList<Locatie> citesteCSV() {
        String path = "Data/Locatii.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            if (line == null) {
                System.out.println("Nu exista locatii!");
            } else {
                while (line != null) {
                    String[] locatie = line.split(",");
                    var LocatieNou = new Locatie(
                            Integer.parseInt(locatie[0]), //id
                            Integer.parseInt(locatie[1]), //city_id
                            locatie[2], //strada
                            Integer.parseInt(locatie[3]) //numar
                    );
                    locatii.add(LocatieNou);
                    line = br.readLine();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return locatii;
    }

    public void scrieCSV(ArrayList<Locatie> locatii){
        try{
            var writer = new FileWriter("Data/DisplayLocatii.csv");
            for(var locatie : locatii){
                writer.write(locatie.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
