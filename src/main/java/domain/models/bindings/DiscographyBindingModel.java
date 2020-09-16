package domain.models.bindings;

import javax.servlet.http.Part;
import java.util.List;

public class DiscographyBindingModel {
    private String name;
    private String year;
    private String duration;
    private String bitrate;
    private boolean canBuy;
    private List<Part> imageFile;
    private List<String> songs;

    public DiscographyBindingModel() {
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

    public boolean getCanBuy() {
        return canBuy;
    }

    public void setCanBuy(boolean canBuy) {
        this.canBuy = canBuy;
    }

    public List<Part> getImageFile() {
        return imageFile;
    }

    public void setImageFile(List<Part> imageFile) {
        this.imageFile = imageFile;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }
}
