package activitytracker;

public class Report {

    private ActivityType activityType;

    private double distance;

    public Report(ActivityType activityType, double distance) {
        if (activityType == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        this.activityType = activityType;
        this.distance = distance;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public double getDistance() {
        return distance;
    }
}
