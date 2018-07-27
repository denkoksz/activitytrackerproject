package activitytracker;

public class ActivityWithTrack implements Activity {

    private ActivityType activityType;
    private Track track;

    public ActivityWithTrack(Track track, ActivityType activityType) {
        if (activityType == null || track == null) {
            throw new IllegalArgumentException("Activity type or track must not be null!");
        }
        this.activityType = activityType;
        this.track = track;
    }

    @Override
    public double getDistance() {
        return track.getDistance();
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }
}
