package Dao;

import Animals.Animal;
import Sightings.Sighting;
import Sightings.SightingDb;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oSightingDao implements sighting{
    Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "ngetich", "12345");
    @Override
    public void add(Sighting sighting) {

        String sql="INSERT INTO sightings(location,ranger_name,animal_id) VALUES (:location,:rangerName,:animal_id)";
        try(Connection conn=sql2o.open()){
            int id=(int) conn.createQuery(sql,true)
                    .bind(sighting)
                    .executeUpdate()
                    .getKey();
            sighting.setSight_id(id);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void read() {
        try(Connection conn=sql2o.open()){
            conn.createQuery("SELECT * FROM sightings")
                    .executeAndFetch(Sighting.class);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public List<SightingDb> findAll() {
        Connection con = sql2o.open();
            String sql = "SELECT * FROM sightings";
            List <SightingDb> allSightings =con.createQuery(sql, true)
                .executeAndFetch(SightingDb.class); //fetch a list

            return allSightings; //raw sql


    }

    @Override
    public List<String> findById(int id) {

        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
        String sql="DELETE * FROM sightings";
        try(Connection conn=sql2o.open()){
            conn.createQuery(sql,true)
                    .executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Un-able to delete ");
        }
    }
}
