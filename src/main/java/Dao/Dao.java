package Dao;
import Animals.Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Dao implements DaoInterface {

   Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "ngetich", "12345");

    @Override
    public   void add(Animal animal) {
       Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "ngetich", "12345");
        try {
            String sql = "INSERT INTO animals (name,health, age,endangered) VALUES (:name, :age, :health,:endangered)";
            Connection con = sql2o.open();
             int id= (int) con.createQuery(sql, true)
                    .bind(animal)
                    .executeUpdate()
                    .getKey();
        } catch (Exception ex) {
            System.out.println("Invalid request");
            ex.printStackTrace();
        }
    }
    @Override
    public List<Animal> findAll() {
        Connection con = sql2o.open();
            String sql = "SELECT * FROM animals";
            return con.createQuery(sql, true) //raw sql
                    .executeAndFetch(Animal.class); //fetch a list
    }
    @Override
    public void updateById(int id) {
        String sql = "SELECT * FROM animals WHERE id=:id";
        try(Connection conn=sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetch(Animal.class);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Un-able to delete ");
        }

    }
    @Override
    public void findById(int id) {

    }
    @Override
    public void delete(int id) {
    }
    @Override
    public void deleteAll() {
        String sql="DELETE * FROM animals";
        try (Connection con = sql2o.open() ){
             con.createQuery(sql)
                    .executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Un-able to delete ");
        }



    }
}
