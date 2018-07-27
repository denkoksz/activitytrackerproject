package activitytracker;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        if (trackPoint == null) {
            throw new IllegalArgumentException("Trackpoint must not be null!");
        }
        trackPoints.add(trackPoint);
    }


    public double getFullElevation() {
        if (trackPoints == null || trackPoints.size() == 0) {
            throw new IllegalArgumentException("Trackpoints must not be null or empty!");
        }
        double sum = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            if (trackPoints.get(i + 1).getElevation() > trackPoints.get(i).getElevation()) {
                sum += trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation();
            }
        }
        return sum;
    }

    public double getFullDecrease() {
        if (trackPoints == null || trackPoints.size() == 0) {
            throw new IllegalArgumentException("Trackpoints must not be null or empty!");
        }
        double sum = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            if (trackPoints.get(i + 1).getElevation() < trackPoints.get(i).getElevation()) {
                sum += trackPoints.get(i).getElevation() - trackPoints.get(i + 1).getElevation();
            }
        }
        return sum;
    }

    public double getDistance() {
        if (trackPoints == null || trackPoints.size() == 0) {
            throw new IllegalArgumentException("Trackpoints must not be null or empty!");
        }
        if (trackPoints.size() == 1) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            sum += trackPoints.get(i).getDistanceFrom(trackPoints.get(i + 1));
        }
        return sum;
    }

    public Coordinate findMinimumCoordinate() {
        if (trackPoints == null || trackPoints.size() == 0) {
            throw new IllegalArgumentException("Trackpoints must not be null or empty!");
        }
        double minLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double minLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() < minLatitude) {
                minLatitude = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() < minLongitude) {
                minLongitude = trackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(minLatitude, minLongitude);
    }

    public Coordinate findMaximumCoordinate() {
        if (trackPoints == null || trackPoints.size() == 0) {
            throw new IllegalArgumentException("Trackpoints must not be null or empty!");
        }
        double maxLatitude = trackPoints.get(0).getCoordinate().getLatitude();
        double maxLongitude = trackPoints.get(0).getCoordinate().getLongitude();
        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() > maxLatitude) {
                maxLatitude = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() > maxLongitude) {
                maxLongitude = trackPoint.getCoordinate().getLongitude();
            }
        }
        return new Coordinate(maxLatitude, maxLongitude);
    }

    public double getRectangleArea() {
        double a = findMaximumCoordinate().getLatitude() - findMinimumCoordinate().getLatitude();
        double b = findMaximumCoordinate().getLongitude() - findMinimumCoordinate().getLongitude();
        return a * b;
    }
}
