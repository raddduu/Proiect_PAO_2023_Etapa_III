package Constants;

public class Constants {
    //CRUD Orase
    public static final String QUERY_TOATE_ORASELE = "SELECT * FROM oras";

    public static final String QUERY_ACTUALIZEAZA_ORAS = "UPDATE oras SET nume = ?, nr_locuitori = ? WHERE id = ?";

    public static final String QUERY_CREAZA_ORAS = "INSERT INTO oras (id, nume, nr_locuitori) VALUES (?, ?, ?)";

    public static final String QUERY_STERGE_ORAS = "DELETE FROM oras WHERE id = ?";

    //CRUD Locatii
    public static final String QUERY_TOATE_LOCATIILE = "SELECT * FROM locatie";

    public static final String QUERY_ACTUALIZEAZA_LOCATIE = "UPDATE locatie SET cityid = ?, strada = ?, numar = ? WHERE id = ?";

    public static final String QUERY_CREAZA_LOCATIE = "INSERT INTO locatie (id, cityid, strada, numar) VALUES (?, ?, ?, ?)";

    public static final String QUERY_STERGE_LOCATIE = "DELETE FROM locatie WHERE id = ?";

    //CRUD Soferi
    public static final String QUERY_TOTI_SOFERII = "SELECT * FROM sofer";

    public static final String QUERY_ACTUALIZEAZA_SOFER = "UPDATE sofer SET prenume = ?, nume_de_familie = ?, gen = ?, an_nastere = ?, luna_nastere = ?, zi_nastere = ?, ani_experienta = ?, nr_clienti = ?, scor_total = ? WHERE id = ?";

    public static final String QUERY_CREAZA_SOFER = "INSERT INTO sofer (id, prenume, nume_de_familie, gen, an_nastere, luna_nastere, zi_nastere, ani_experienta, nr_clienti, scor_total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String QUERY_STERGE_SOFER = "DELETE FROM sofer WHERE id = ?";

    //CRUD Bucatari
    public static final String QUERY_TOTI_BUCATARII = "SELECT * FROM bucatar";

    public static final String QUERY_ACTUALIZEAZA_BUCATAR = "UPDATE bucatar SET prenume = ?, nume_de_familie = ?, gen = ?, an_nastere = ?, luna_nastere = ?, zi_nastere = ?, ani_experienta = ?, specializare = ?, rang = ?, restaurantid = ? WHERE id = ?";

    public static final String QUERY_CREAZA_BUCATAR = "INSERT INTO bucatar (id, prenume, nume_de_familie, gen, an_nastere, luna_nastere, zi_nastere, ani_experienta, specializare, rang, restaurantid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String QUERY_STERGE_BUCATAR = "DELETE FROM bucatar WHERE id = ?";


}
