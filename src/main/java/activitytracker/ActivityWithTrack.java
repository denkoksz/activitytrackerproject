package activitytracker;

public class ActivityWithTrack implements Activity {

    private ActivityType activityType;

    private Track track;

    public ActivityWithTrack(ActivityType activityType, Track track) {
        if(activityType == null || track == null){
            throw new IllegalArgumentException("...");
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
