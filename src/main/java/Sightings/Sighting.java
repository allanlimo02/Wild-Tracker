package Sightings;

public class Sighting {
    private int animalId;
    private String location;
    private String ranger;
    private int sight_id;

    public Sighting(String location, String ranger, int animalId) {
        this.animalId = animalId;
        this.location = location;
        this.ranger = ranger;

    }

    public int getSight_id() {
        return sight_id;
    }

    public void setSight_id(int sight_id) {
        this.sight_id = sight_id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
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
