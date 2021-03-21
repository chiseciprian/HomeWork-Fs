package ro.fasttrackit.homeWork3.ex1;

import java.util.List;

public class PersonGrouping {

    int startId;
    int endId;

    public PersonGrouping(int startId, int endId) {
        this.startId = startId;
        this.endId = endId;
    }

    public int getStartId() {
        return startId;
    }

    public void setStartId(int startId) {
        this.startId = startId;
    }

    public int getEndId() {
        return endId;
    }

    public void setEndId(int endId) {
        this.endId = endId;
    }
}
