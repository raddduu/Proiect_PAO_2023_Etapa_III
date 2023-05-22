import Config.DatabaseConfiguration;
import Model.*;
import Model.Locatie.Locatie;
import Model.Locatie.LocatieDatabase;
import Model.Oras.Oras;
import Model.Oras.OrasDatabase;
import Model.Persoana.Bucatar.Bucatar;
import Model.Persoana.Bucatar.BucatarDatabase;
import Model.Persoana.Client.Client;
import Model.Persoana.Persoana;
import Model.Persoana.Sofer.Sofer;
import Model.Persoana.Sofer.SoferDatabase;
import Service.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        DatabaseConfiguration connection = new DatabaseConfiguration();
        var soferiDatabase = new SoferDatabase(connection);
        var bucatariDatabase = new BucatarDatabase(connection);
        var oraseDatabase = new OrasDatabase(connection);
        var locatiiDatabase = new LocatieDatabase(connection);

        ProdusService produsService = new ProdusService();
        PersoanaService persoanaService = new PersoanaService();
        ComandaService comandaService = new ComandaService(produsService, persoanaService);
        LocatieService locatieService = new LocatieService();
        OrasService orasService = new OrasService();
        AuditService auditService = new AuditService();

        try {
            persoanaService.readBucatari();
            try {
                for (Bucatar buc : persoanaService.getAllBucatari()) {
                    bucatariDatabase.createBucatar(new Bucatar(buc.getId(), buc.getPrenume(), buc.getNume_de_familie(), buc.getGen(), buc.getAn_nastere(), buc.getLuna_nastere(), buc.getZi_nastere(), buc.getAni_experienta(), buc.getSpecializare(), buc.getRang(), buc.getRestaurantid()));
                }

                System.out.println("Bucatari inserati in baza de date.");
                System.out.println("Continutul Bazei de Date:");
                for (Bucatar bucatar : bucatariDatabase.readBucatari()) {
                    System.out.println(bucatar.toString());
                }

                System.out.println("Introduceti noile date:");
                System.out.println("Nume: ");
                String nume = in.nextLine();
                System.out.println("Prenume: ");
                String prenume = in.nextLine();
                System.out.println("Id: ");
                int id = Integer.parseInt(in.nextLine());
                System.out.println("Gen: ");
                String gen = in.nextLine();
                System.out.println("Anul nasterii: ");
                int an = Integer.parseInt(in.nextLine());
                System.out.println("Luna nasterii: ");
                int luna = Integer.parseInt(in.nextLine());
                System.out.println("Ziua nasterii: ");
                int ziua = Integer.parseInt(in.nextLine());
                System.out.println("Ani de experienta: ");
                int exp = Integer.parseInt(in.nextLine());
                System.out.println("Specializare: ");
                String specializare = in.nextLine();
                System.out.println("Rang: ");
                int rang = Integer.parseInt(in.nextLine());
                System.out.println("Id restaurant: ");
                int rid = Integer.parseInt(in.nextLine());
                Bucatar bucatar = new Bucatar(id, prenume, nume, gen, an, luna, ziua, exp, specializare, rang, rid);
                bucatariDatabase.updateBucatar(bucatar);

                System.out.println("Id-ul bucatarului de sters:");
                int id_buc = Integer.parseInt(in.nextLine());
                bucatariDatabase.deleteBucatar((Bucatar) persoanaService.searchById(id_buc));
            } catch (Exception e) {
                System.out.println("Eroare la inserarea bucatarilor: " + e);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        try {
            persoanaService.readSoferi();
            try {
                for (Sofer sof : persoanaService.getAllSoferi()) {
                    soferiDatabase.createSofer(new Sofer(sof.getId(), sof.getPrenume(), sof.getNume_de_familie(), sof.getGen(), sof.getAn_nastere(), sof.getLuna_nastere(), sof.getZi_nastere(), sof.getAni_experienta(), sof.getNr_clienti(), sof.getScor_total()));
                }
                System.out.println("Soferi inserati in baza de date.");
                System.out.println("Continutul Bazei de Date:");
                for (Sofer sofer : soferiDatabase.readSoferi()) {
                    System.out.println(sofer.toString());
                }

                System.out.println("Introduceti noile date:");
                System.out.println("Nume: ");
                String nume = in.nextLine();
                System.out.println("Prenume: ");
                String prenume = in.nextLine();
                System.out.println("Id: ");
                int id = Integer.parseInt(in.nextLine());
                System.out.println("Gen: ");
                String gen = in.nextLine();
                System.out.println("Anul nasterii: ");
                int an = Integer.parseInt(in.nextLine());
                System.out.println("Luna nasterii: ");
                int luna = Integer.parseInt(in.nextLine());
                System.out.println("Ziua nasterii: ");
                int ziua = Integer.parseInt(in.nextLine());
                System.out.println("Ani de experienta: ");
                int exp = Integer.parseInt(in.nextLine());
                System.out.println("Numar client: ");
                int nrc = Integer.parseInt(in.nextLine());
                System.out.println("Scor total: ");
                int scor = Integer.parseInt(in.nextLine());
                Sofer sofer = new Sofer(id, prenume, nume, gen, an, luna, ziua, exp, nrc, scor);
                soferiDatabase.updateSofer(sofer);

                System.out.println("Id-ul soferului de sters:");
                int id_sof = Integer.parseInt(in.nextLine());
                soferiDatabase.deleteSofer((Sofer) persoanaService.searchById(id_sof));
            } catch (Exception e) {
                System.out.println("Eroare la inserarea soferilor: " + e);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            locatieService.readLocatii();
            try {
                for (Locatie loc : locatieService.getAllLocatii()) {
                    locatiiDatabase.createLocatie(new Locatie(loc.getId(), loc.getCityid(), loc.getStrada(), loc.getNumar()));
                }

                System.out.println("Locatii inserate in baza de date.");
                System.out.println("Introduceti noile date:");
                System.out.println("Id: ");
                int id = Integer.parseInt(in.nextLine());
                System.out.println("City Id: ");
                int cityid = Integer.parseInt(in.nextLine());
                System.out.println("Strada: ");
                String strada = in.nextLine();
                System.out.println("Numar: ");
                int numar = Integer.parseInt(in.nextLine());
                Locatie locatie = new Locatie(id, cityid, strada, numar);
                locatiiDatabase.updateLocatie(locatie);

                System.out.println("Id-ul locatiei de sters:");
                int id_loc = Integer.parseInt(in.nextLine());
                locatiiDatabase.deleteLocatie(locatieService.searchById(id_loc));
            } catch (Exception e) {
                System.out.println("Eroare la inserarea locatiilor: " + e);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            orasService.readOrase();
            try {
                for (Oras oras : orasService.getAllOrase()) {
                    oraseDatabase.createOras(new Oras(oras.getId(), oras.getNume(), oras.getNr_locuitori()));
                }
                System.out.println("Orase inserate in baza de date.");
                System.out.println("Introduceti noile date:");
                System.out.println("Id: ");
                int id = Integer.parseInt(in.nextLine());
                System.out.println("Nume: ");
                String nume = in.nextLine();
                System.out.println("Numar locuitori: ");
                int numar_loc = Integer.parseInt(in.nextLine());
                Oras oras = new Oras(id, nume, numar_loc);
                oraseDatabase.updateOras(oras);

                System.out.println("Id-ul locatiei de sters:");
                int id_loc = Integer.parseInt(in.nextLine());
                oraseDatabase.deleteOras(orasService.searchById(id_loc));
            } catch (Exception e) {
                System.out.println("Eroare la inserarea oraselor: " + e);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}