package SightingDAO;

import SightingDAO.SightingDao;
import Sightings.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class SightingImplementing implements SightingDao {

    @Override
    public void add(Sighting sighting) {
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "ngetich", "12345");
        try {
            String sql = "INSERT INTO sighting (location,ranger_name,animal_id) VALUES (:location,:rangerName,:animalId)";
            Connection con = sql2o.open();
            int id= (int) con.createQuery(sql, true)
                    .bind(sighting)
                    .executeUpdate()
                    .getKey();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
