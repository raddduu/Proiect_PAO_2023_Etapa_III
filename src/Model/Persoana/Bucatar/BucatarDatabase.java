package Model.Persoana.Bucatar;

import Config.DatabaseConfiguration;
import Constants.Constants;
import Model.Persoana.Bucatar.Bucatar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BucatarDatabase {
    private final DatabaseConfiguration databaseConfiguration;

    public BucatarDatabase(DatabaseConfiguration databaseCon) {
        databaseConfiguration = databaseCon;
    }
    public ArrayList<Bucatar> readBucatari() throws SQLException {
        Statement statement = databaseConfiguration.getConnection().createStatement();
        ArrayList<Bucatar> bucatari = new ArrayList<>();
        try{
            ResultSet resultSet = statement.executeQuery(Constants.QUERY_TOTI_BUCATARII);
            while(resultSet.next()) {
                Bucatar bucatar = new Bucatar(resultSet.getInt("id"),
                        resultSet.getString("prenume"),
                        resultSet.getString("nume_de_familie"),
                        resultSet.getString("gen"),
                        resultSet.getInt("an_nastere"),
                        resultSet.getInt("luna_nastere"),
                        resultSet.getInt("zi_nastere"),
                        resultSet.getInt("ani_experienta"),
                        resultSet.getString("specializare"),
                        resultSet.getInt("rang"),
                        resultSet.getInt("restaurantid")
                );
                bucatari.add(bucatar);
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return bucatari;
    }

    public void updateBucatar(Bucatar bucatar){
        try{
            String query = Constants.QUERY_ACTUALIZEAZA_BUCATAR;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, bucatar.getId());
            preparedStmt.setString(2, bucatar.getPrenume());
            preparedStmt.setString(3,bucatar.getNume_de_familie());
            preparedStmt.setString(4,bucatar.getGen());
            preparedStmt.setInt(5, bucatar.getAn_nastere());
            preparedStmt.setInt(6, bucatar.getLuna_nastere());
            preparedStmt.setInt(7, bucatar.getZi_nastere());
            preparedStmt.setInt(8, bucatar.getAni_experienta());
            preparedStmt.setString(9, bucatar.getSpecializare());
            preparedStmt.setInt(10, bucatar.getRang());
            preparedStmt.setInt(11, bucatar.getRestaurantid());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void createBucatar(Bucatar bucatar) throws SQLException{
        Statement statement = databaseConfiguration.getConnection().createStatement();
        try{
            String query =  Constants.QUERY_CREAZA_BUCATAR;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, bucatar.getId());
            preparedStmt.setString(2, bucatar.getPrenume());
            preparedStmt.setString(3,bucatar.getNume_de_familie());
            preparedStmt.setString(4,bucatar.getGen());
            preparedStmt.setInt(5, bucatar.getAn_nastere());
            preparedStmt.setInt(6, bucatar.getLuna_nastere());
            preparedStmt.setInt(7, bucatar.getZi_nastere());
            preparedStmt.setInt(8, bucatar.getAni_experienta());
            preparedStmt.setString(9, bucatar.getSpecializare());
            preparedStmt.setInt(10, bucatar.getRang());
            preparedStmt.setInt(11, bucatar.getRestaurantid());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void deleteBucatar(Bucatar bucatar){
        try{
            String query = Constants.QUERY_STERGE_BUCATAR;
            PreparedStatement preparedStmt = databaseConfiguration.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, bucatar.getId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
