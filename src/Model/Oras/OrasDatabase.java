package Model.Oras;

import java.sql.*;
import java.util.ArrayList;

import Config.DatabaseConfiguration;
import Constants.Constants;

public class OrasDatabase {
    private final DatabaseConfiguration databaseConfiguration;

    public OrasDatabase(DatabaseConfiguration databaseCon) {
        databaseConfiguration = databaseCon;
    }
    public  ArrayList<Oras> readOrase() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ArrayList<Oras> orase = new ArrayList<>();
        try{
            ResultSet resultSet = statement.executeQuery(Constants.QUERY_TOATE_ORASELE);
            while(resultSet.next()) {
                Oras oras = new Oras(resultSet.getInt("id"),
                        resultSet.getString("nume"),
                        resultSet.getInt("nr_locuitori")
                );
                orase.add(oras);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return orase;
    }

    public void updateOras(Oras oras){
        try{
            String query = Constants.QUERY_ACTUALIZEAZA_ORAS;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setString(1, oras.getNume());
            preparedStmt.setInt(2, oras.getNr_locuitori());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void createOras(Oras oras) throws SQLException{
        Statement statement = databaseConfiguration.getConnection().createStatement();
        try{
            String query =  Constants.QUERY_CREAZA_ORAS;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, oras.getId());
            preparedStmt.setString(2, oras.getNume());
            preparedStmt.setInt(3, oras.getNr_locuitori());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deleteOras(Oras oras){
        try{
            String query = Constants.QUERY_STERGE_ORAS;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, oras.getId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
