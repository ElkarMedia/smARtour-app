package eus.elkarmedia.smartour.core.model;

import android.location.Location;

/**
 * Created by lenovo on 27/05/2015.
 */
public class Game {

    private Long id;
    private String title;
    private Geolocation location;

    public Game() {
    }

    public Game(long id, String title, Geolocation location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Geolocation getLocation() {
        return location;
    }

    public void setLocation(Geolocation location) {
        this.location = location;
    }

    public void setLocation(double latitude, double longitude, int altitude) {
        this.location = new Geolocation(latitude, longitude, altitude);
    }
    public void setLocation(double latitude, double longitude) {
        this.location = new Geolocation(latitude, longitude);
    }
    public float getDistance(Location location) {
        Location gameLocation = new Location("dummyprovider");
        gameLocation.setLatitude(this.location.getLatitude());
        gameLocation.setLongitude(this.location.getLongitude());
        return gameLocation.distanceTo(location);
    }

}
