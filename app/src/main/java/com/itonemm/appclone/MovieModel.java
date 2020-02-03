package com.itonemm.appclone;

public class MovieModel {
    String name;
    String image;
    String video;
    String category;
    String series;

    public MovieModel(String name, String image, String video, String category, String series) {
        this.name = name;
        this.image = image;
        this.video = video;
        this.category = category;
        this.series = series;
    }

    public MovieModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
