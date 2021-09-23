package Sightings;

import java.util.ArrayList;

public class Sighting {
    private int animal_id;
    private String location;
    private String rangerName;
    private int sight_id;

    public Sighting(String location, String rangerName, int animal_id) {
        this.location = location;
        this.rangerName = rangerName;
        this.animal_id = animal_id;

    }


    public int getSight_id() {
        return sight_id;
    }

    public void setSight_id(int sight_id) {
        this.sight_id = sight_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }
    private static ArrayList<Sighting> instances = new ArrayList<>();


    public static ArrayList<Sighting> getAll(){
        return instances;
    }
}
