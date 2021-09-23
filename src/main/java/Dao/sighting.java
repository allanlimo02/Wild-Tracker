package Dao;

import Sightings.Sighting;

import java.util.List;

public interface sighting {
    void add(Sighting sighting);
    void read();
    List<String> findById(int id);
    void update();
    void delete();
}
