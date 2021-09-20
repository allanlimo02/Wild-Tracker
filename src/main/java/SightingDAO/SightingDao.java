package SightingDAO;
import Sightings.Sighting;

public interface SightingDao {
    void add(Sighting sighting);
    void read();
    void update();
    void delete();

}
