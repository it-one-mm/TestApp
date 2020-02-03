package com.itonemm.appclone;

public class SeriesModel {
    String name;
    String image;
    String video;
    String category;

    public SeriesModel(String name, String image, String video, String category) {
        this.name = name;
        this.image = image;
        this.video = video;
        this.category = category;
    }

    public SeriesModel() {
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
}
