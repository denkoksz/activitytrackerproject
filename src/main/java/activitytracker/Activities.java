package activitytracker;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        if (activities == null) {
            throw new IllegalArgumentException("Activities must not be null!");
        }
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activities must not be null!");
        }
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> result = new ArrayList<>();
        double basketballDistance = 0;
        double bikingDistance = 0;
        double hikingDistance = 0;
        double runningDistance = 0;
        for (Activity item: activities) {
            if (item.getType().equals(ActivityType.BASKETBALL)) {
                basketballDistance += item.getDistance();
            }
            if (item.getType().equals(ActivityType.BIKING)) {
                bikingDistance += item.getDistance();
            }
            if (item.getType().equals(ActivityType.HIKING)) {
                hikingDistance += item.getDistance();
            }
            if (item.getType().equals(ActivityType.RUNNING)) {
                runningDistance += item.getDistance();
            }
        }
        result.add(new Report(ActivityType.BASKETBALL, basketballDistance));
        result.add(new Report(ActivityType.BIKING, bikingDistance));
        result.add(new Report(ActivityType.HIKING, hikingDistance));
        result.add(new Report(ActivityType.RUNNING, runningDistance));

        return result;
    }

    public int numberOfTrackActivities() {
        int count = 0;
        for (Activity item: activities) {
            if (item instanceof ActivityWithTrack) {
                count++;
            }
        }
        return count;
    }

    public int numberOfWithoutTrackActivities() {
        int count = 0;
        for (Activity item: activities) {
            if (item instanceof ActivityWithoutTrack) {
                count++;
            }
        }
        return count;
    }
}
