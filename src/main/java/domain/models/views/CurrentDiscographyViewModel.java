package domain.models.views;

import java.util.List;

public class CurrentDiscographyViewModel {
    private String id;
    private String name;
    private String year;
    private String duration;
    private String bitrate;
    private boolean canBuy;
    private List<ImageViewModel> images;
    private List<VideosViewModel> videos;

    public CurrentDiscographyViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBitrate() {
        return bitrate;
    }

    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }

    public boolean isCanBuy() {
        return canBuy;
    }

    public void setCanBuy(boolean canBuy) {
        this.canBuy = canBuy;
    }

    public List<ImageViewModel> getImages() {
        return images;
    }

    public void setImages(List<ImageViewModel> images) {
        this.images = images;
    }

    public List<VideosViewModel> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosViewModel> videos) {
        this.videos = videos;
    }
}
