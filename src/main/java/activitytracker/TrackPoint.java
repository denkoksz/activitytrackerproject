package activitytracker;

public class TrackPoint {

    private Coordinate coordinate;

    private double elevation;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getElevation() {
        return elevation;
    }

    public double getDistanceFrom(TrackPoint trackpoint) {
        double trackpointLatitude = trackpoint.getCoordinate().getLatitude();
        double trackointLongtitude = trackpoint.getCoordinate().getLongtitude();
        double latitude = coordinate.getLatitude();
        double lontitude = coordinate.getLongtitude();

        double result = Math.sqrt(Math.pow(trackpointLatitude - latitude, 2) + Math.pow(trackointLongtitude - lontitude, 2));
        return result;
    }
}
