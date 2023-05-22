package Model.Persoana.Sofer;

import Config.DatabaseConfiguration;
import Constants.Constants;
import Model.Persoana.Sofer.Sofer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SoferDatabase {
    private final DatabaseConfiguration databaseConfiguration;

    public SoferDatabase(DatabaseConfiguration databaseCon) {
        databaseConfiguration = databaseCon;
    }
    public ArrayList<Sofer> readSoferi() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ArrayList<Sofer> soferi = new ArrayList<>();
        try{
            ResultSet resultSet = statement.executeQuery(Constants.QUERY_TOTI_SOFERII);
            while(resultSet.next()) {
                Sofer sofer = new Sofer(resultSet.getInt("id"),
                        resultSet.getString("prenume"),
                        resultSet.getString("nume_de_familie"),
                        resultSet.getString("gen"),
                        resultSet.getInt("an_nastere"),
                        resultSet.getInt("luna_nastere"),
                        resultSet.getInt("zi_nastere"),
                        resultSet.getInt("ani_experienta"),
                        resultSet.getInt("nr_clienti"),
                        resultSet.getInt("scor_total")
                );
                soferi.add(sofer);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return soferi;
    }

    public void updateSofer(Sofer sofer){
        try{
            String query = Constants.QUERY_ACTUALIZEAZA_SOFER;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, sofer.getId());
            preparedStmt.setString(2, sofer.getPrenume());
            preparedStmt.setString(3,sofer.getNume_de_familie());
            preparedStmt.setString(4,sofer.getGen());
            preparedStmt.setInt(5, sofer.getAn_nastere());
            preparedStmt.setInt(6, sofer.getLuna_nastere());
            preparedStmt.setInt(7, sofer.getZi_nastere());
            preparedStmt.setInt(8, sofer.getAni_experienta());
            preparedStmt.setInt(9, sofer.getNr_clienti());
            preparedStmt.setInt(10, sofer.getScor_total());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void createSofer(Sofer sofer) throws SQLException{
        Statement statement = databaseConfiguration.getConnection().createStatement();
        try{
            String query =  Constants.QUERY_CREAZA_SOFER;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, sofer.getId());
            preparedStmt.setString(2, sofer.getPrenume());
            preparedStmt.setString(3,sofer.getNume_de_familie());
            preparedStmt.setString(4,sofer.getGen());
            preparedStmt.setInt(5, sofer.getAn_nastere());
            preparedStmt.setInt(6, sofer.getLuna_nastere());
            preparedStmt.setInt(7, sofer.getZi_nastere());
            preparedStmt.setInt(8, sofer.getAni_experienta());
            preparedStmt.setInt(9, sofer.getNr_clienti());
            preparedStmt.setInt(10, sofer.getScor_total());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deleteSofer(Sofer sofer){
        try{
            String query = Constants.QUERY_STERGE_SOFER;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, sofer.getId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
