package Service;

import Model.Locatie.Locatie;
import Model.Oras.Oras;
import Model.Oras.OrasSingleton;
import Model.Persoana.Bucatar.Bucatar;
import Model.Persoana.Bucatar.BucatarSingleton;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OrasService {
    private ArrayList<Oras> orase = new ArrayList<>();
    public void readOrase() throws ParseException {
        orase = OrasSingleton.getInstance().citesteCSV();
        OrasSingleton.getInstance().scrieCSV(orase);
    }

    public List<Oras> getAllOrase() {
        List<Oras> ors = new ArrayList<>();
        ors.addAll(orase);
        return ors;
    }

    public Oras searchById(int id) {
        for (Oras oras : orase) {
            if (oras.getId() == id) {
                return oras;
            }
        }
        return null;
    }
}
