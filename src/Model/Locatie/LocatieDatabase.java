package Model.Locatie;

import java.sql.*;
import java.util.ArrayList;

import Config.DatabaseConfiguration;
import Constants.Constants;

public class LocatieDatabase {
    private final DatabaseConfiguration databaseConfiguration;

    public LocatieDatabase(DatabaseConfiguration databaseCon) {
        databaseConfiguration = databaseCon;
    }
    public  ArrayList<Locatie> readLocatii() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ArrayList<Locatie> locatii = new ArrayList<>();
        try{
            ResultSet resultSet = statement.executeQuery(Constants.QUERY_TOATE_LOCATIILE);
            while(resultSet.next()) {
                Locatie locatie = new Locatie(resultSet.getInt("id"),
                        resultSet.getInt("cityid"),
                        resultSet.getString("strada"),
                        resultSet.getInt("numar")
                );
                locatii.add(locatie);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return locatii;
    }

    public void updateLocatie(Locatie locatie){
        try{
            String query = Constants.QUERY_ACTUALIZEAZA_LOCATIE;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, locatie.getCityid());
            preparedStmt.setString(2, locatie.getStrada());
            preparedStmt.setInt(3, locatie.getNumar());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void createLocatie(Locatie locatie) throws SQLException{
        Statement statement = databaseConfiguration.getConnection().createStatement();
        try{
            String query =  Constants.QUERY_CREAZA_LOCATIE;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, locatie.getId());
            preparedStmt.setInt(2, locatie.getCityid());
            preparedStmt.setString(3, locatie.getStrada());
            preparedStmt.setInt(4, locatie.getNumar());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deleteLocatie(Locatie locatie){
        try{
            String query = Constants.QUERY_STERGE_LOCATIE;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, locatie.getId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
