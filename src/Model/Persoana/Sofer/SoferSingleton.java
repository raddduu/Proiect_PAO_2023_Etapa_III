package Model.Persoana.Sofer;

import Model.Persoana.Bucatar.Bucatar;
import Model.Persoana.Bucatar.BucatarSingleton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SoferSingleton {
    private static SoferSingleton instance = null;
    private ArrayList<Sofer> soferi = new ArrayList<Sofer>();

    public static SoferSingleton getInstance()
    {
        if (instance == null)
            instance = new SoferSingleton();
        return instance;
    }

    public static void setInstance(SoferSingleton instance) {
        SoferSingleton.instance = instance;
    }

    public ArrayList<Sofer> citesteCSV() {
        String path = "Data/Soferi.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            if (line == null) {
                System.out.println("Nu exista soferi!");
            } else {
                while (line != null) {
                    String[] sofer = line.split(",");
                    var soferNou = new Sofer(
                            Integer.parseInt(sofer[0]), //id
                            sofer[1], //prenume
                            sofer[2], //nume
                            sofer[3], //gen
                            Integer.parseInt(sofer[4]), //an
                            Integer.parseInt(sofer[5]), //luna
                            Integer.parseInt(sofer[6]), //zi
                            Integer.parseInt(sofer[7]), //ani_exp
                            Integer.parseInt(sofer[8]), //rang
                            Integer.parseInt(sofer[9]) //scor
                    );
                    soferi.add(soferNou);
                    line = br.readLine();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return soferi;
    }

    public void scrieCSV(ArrayList<Sofer> soferi){
        try{
            var writer = new FileWriter("Data/DisplaySoferi.csv");
            for(var sofer : soferi){
                writer.write(sofer.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
