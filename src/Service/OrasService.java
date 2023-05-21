package Service;

import Model.Oras.Oras;
import Model.Oras.OrasSingleton;
import Model.Persoana.Bucatar.Bucatar;
import Model.Persoana.Bucatar.BucatarSingleton;

import java.text.ParseException;
import java.util.ArrayList;

public class OrasService {
    private ArrayList<Oras> orase = new ArrayList<>();
    public void readOrase() throws ParseException {
        orase = OrasSingleton.getInstance().citesteCSV();
        OrasSingleton.getInstance().scrieCSV(orase);
    }
}
