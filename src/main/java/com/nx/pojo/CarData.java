package com.nx.pojo;

public class CarData {
    private String url;
    private Float distanceFront;
    private Float distanceLeft;
    private Float distanceRight;
    private Float time;

    @Override
    public String toString() {
        return "CarData{" +
                "url='" + url + '\'' +
                ", distanceFront=" + distanceFront +
                ", distanceLeft=" + distanceLeft +
                ", distanceRight=" + distanceRight +
                ", time=" + time +
                '}';
    }

    public CarData() {
    }

    public CarData(String url, Float distanceFront, Float distanceLeft, Float distanceRight, Float time) {
        this.url = url;
        this.distanceFront = distanceFront;
        this.distanceLeft = distanceLeft;
        this.distanceRight = distanceRight;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Float getDistanceFront() {
        return distanceFront;
    }

    public void setDistanceFront(Float distanceFront) {
        this.distanceFront = distanceFront;
    }

    public Float getDistanceLeft() {
        return distanceLeft;
    }

    public void setDistanceLeft(Float distanceLeft) {
        this.distanceLeft = distanceLeft;
    }

    public Float getDistanceRight() {
        return distanceRight;
    }

    public void setDistanceRight(Float distanceRight) {
        this.distanceRight = distanceRight;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }
}
