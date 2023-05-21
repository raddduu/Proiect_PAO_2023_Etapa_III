package Service;

import Model.Locatie.Locatie;
import Model.Locatie.LocatieSingleton;
import Model.Persoana.Bucatar.Bucatar;
import Model.Persoana.Bucatar.BucatarSingleton;
import Model.Persoana.Sofer.Sofer;

import java.text.ParseException;
import java.util.ArrayList;

public class LocatieService {
    private ArrayList<Locatie> locatii = new ArrayList<>();
    public void readLocatii() throws ParseException {
        locatii = LocatieSingleton.getInstance().citesteCSV();
        LocatieSingleton.getInstance().scrieCSV(locatii);
    }
}
