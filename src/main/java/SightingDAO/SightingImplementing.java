package SightingDAO;

import SightingDAO.SightingDao;
import Sightings.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class SightingImplementing implements SightingDao {
    Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "ngetich", "12345");

    @Override
    public void add(Sighting sighting) {
          String sql="INSERT INTO sightings(location,ranger_name,animal_id) VALUES (':location',':rangerName',':animal_id')";
          Connection conn=sql2o.open();
          int id=(int) conn.createQuery(sql,true)
                  .bind(sighting)
                  .executeUpdate()
                  .getKey();
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
