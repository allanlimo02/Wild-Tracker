package Dao;

import Animals.Endangered;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Dao implements DaoInterface {

   // Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wild_track", "ngetich", "12345");
    @Override
    public  void add(Endangered endangered) {
        try {
            Class.forName("org.h2.Driver");
            Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wild_track", "ngetich", "12345");
            String sql = "INSERT INTO endangered; (name,age,health ) VALUES (:name, :age, :health)";
            Connection con = sql2o.open();
            int id = (int) con.createQuery(sql, true)
                    .bind(endangered) //use name and location from match object
                    .executeUpdate()
                    .getKey();
        } catch (Exception ex) {
            System.out.println("Invalid request");
            ex.printStackTrace();
        }
    }

    @Override
    public void updateById(int id) {

    }

    @Override
    public void findById(int id) {

    }

    @Override
    public void find() {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete() {

    }
}
