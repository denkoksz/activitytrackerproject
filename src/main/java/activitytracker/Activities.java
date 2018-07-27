package activitytracker;

import java.util.List;

public class Activities {

    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        if(activities == null){
            throw new IllegalArgumentException("...");
        }
        this.activities = activities;
    }

    public void addActivity(Activity activity){
        if(activity == null){
            throw new IllegalArgumentException("...");
        }
        activities.add(activity);
    }

    public List<Report> distanceByTypes(){

    }

    public int numberOfTrackActivities(){

    }

    public int numberOfWithoutTrackActivities(){

    }

}
