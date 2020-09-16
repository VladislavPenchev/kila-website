package domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "discographies")
public class Discography extends BaseEntity {
    private String name;
    private String year;
    private String duration;
    private String bitrate;
    private boolean canBuy;

    private Discography() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Column
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Column
    public String getBitrate() {
        return bitrate;
    }

    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }

    @Column(name = "can_buy")
    public boolean getCanBuy() {
        return canBuy;
    }

    public void setCanBuy(boolean canBuy) {
        this.canBuy = canBuy;
    }

    public static class DiscographyBuilder {
        private String name;
        private String year;
        private String duration;
        private String bitrate;
        private boolean canBuy;

        public DiscographyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public DiscographyBuilder setYear(String year) {
            this.year = year;
            return this;
        }

        public DiscographyBuilder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public DiscographyBuilder setBitrate(String bitrate) {
            this.bitrate = bitrate;
            return this;
        }

        public DiscographyBuilder setCanBuy(boolean canBuy) {
            this.canBuy = canBuy;
            return this;
        }

        public Discography build() {
            Discography discography = new Discography();
            discography.name = name;
            discography.year = year;
            discography.duration = duration;
            discography.bitrate = bitrate;
            discography.year = year;

            return discography;
        }
    }


}
