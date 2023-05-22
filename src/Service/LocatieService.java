package Service;

import Model.Locatie.Locatie;
import Model.Locatie.LocatieSingleton;
import Model.Persoana.Bucatar.Bucatar;
import Model.Persoana.Bucatar.BucatarSingleton;
import Model.Persoana.Persoana;
import Model.Persoana.Sofer.Sofer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class LocatieService {
    private ArrayList<Locatie> locatii = new ArrayList<>();
    public void readLocatii() throws ParseException {
        locatii = LocatieSingleton.getInstance().citesteCSV();
        LocatieSingleton.getInstance().scrieCSV(locatii);
    }
    public List<Locatie> getAllLocatii() {
        List<Locatie> locs = new ArrayList<>();
        locs.addAll(locatii);
        return locs;
    }

    public Locatie searchById(int id) {
        for (Locatie loc : locatii) {
            if (loc.getId() == id) {
                return loc;
            }
        }
        return null;
    }
}
