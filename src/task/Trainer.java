package task;

import java.util.ArrayList;
import java.util.List;

public class Trainer implements Exercise {

    public List<Viewer> viewers;
    public String exercise;

    public Trainer() {
        this.viewers = new ArrayList<>();
    }

    @Override
    public void watch(Viewer exerciseViewer) {
        this.viewers.add(exerciseViewer);
        exerciseViewer.setExercise(this);
    }

    @Override
    public void stopWatching(Viewer exerciseViewer) {
        this.viewers.remove(exerciseViewer);
    }

    @Override
    public void notifyViewers() {
        for(Viewer viewer: this.viewers) {
            viewer.update();
        }
    }

    @Override
    public String getUpdate() {
        return this.getExercise();
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        System.out.println("Trainer has started doing " + exercise);
        this.exercise = exercise;
        this.notifyViewers();
    }
}
