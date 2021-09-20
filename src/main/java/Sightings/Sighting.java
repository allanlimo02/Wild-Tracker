package Sightings;

public class Sighting {
    private String animal_id;
    private String location;
    private String ranger;
    private int sight_id;

    public Sighting(String location, String ranger, String animal_id) {
        this.location = location;
        this.ranger = ranger;
        this.animal_id = animal_id;

    }

    public int getSight_id() {
        return sight_id;
    }

    public void setSight_id(int sight_id) {
        this.sight_id = sight_id;
    }

    public String getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(String animal_id) {
        this.animal_id = animal_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRanger() {
        return ranger;
    }

    public void setRanger(String ranger) {
        this.ranger = ranger;
    }
}
