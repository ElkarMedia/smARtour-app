package eus.elkarmedia.smartour.core.model;

/**
 * Created by lenovo on 27/05/2015.
 */
public class Geolocation {

    public final static String EXTRA_LATITUDE = "latitude";
    public final static String EXTRA_LONGITUDE = "longitude";
    public final static String EXTRA_ALTITUDE = "altitude";

    private Double latitude;
    private Double longitude;
    private int altitude;

    public Geolocation() {
    }

    public Geolocation(double latitude, double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Geolocation(double latitude, double longitude, int altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
}
