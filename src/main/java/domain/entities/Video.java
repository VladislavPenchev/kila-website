package domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "videos")
public class Video extends BaseEntity {
    private String name;
    private String imageId;
    private String description;
    private String youTubeUrl;
    private List<Tag> tags;
    private String time;
    private List<Singer> singers;
    private String discographyId;

    private Video() {

    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "image_id")
    public String getImageId() {
        return imageId;
    }

    @Column(name = "description", columnDefinition = "text")
    public String getDescription() {
        return description;
    }

    @Column(name = "youtube_url")
    public String getYouTubeUrl() {
        return youTubeUrl;
    }

    @ManyToMany(targetEntity = Tag.class,
            cascade = CascadeType.ALL)
    @JoinTable(name = "videos_tags",
            joinColumns = @JoinColumn(name = "video_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    public List<Tag> getTags() {
        return tags;
    }

    @Column(name = "time")
    public String getTime() {
        return time;
    }

    @ManyToMany(targetEntity = Singer.class,
            cascade = CascadeType.ALL)
    @JoinTable(name = "videos_singers",
            joinColumns = @JoinColumn(name = "video_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "singer_id", referencedColumnName = "id"))
    public List<Singer> getSingers() {
        return singers;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setImageId(String imageId) {
        this.imageId = imageId;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setYouTubeUrl(String youTubeUrl) {
        this.youTubeUrl = youTubeUrl;
    }

    private void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    private void setTime(String time) {
        this.time = time;
    }

    private void setSingers(List<Singer> singers) {
        this.singers = singers;
    }

    @Column(name = "discography_id")
    public String getDiscographyId() {
        return discographyId;
    }

    public void setDiscographyId(String discographyId) {
        this.discographyId = discographyId;
    }

    public static class VideoBuilder {
        private String name;
        private String imageId;
        private String description;
        private String youTubeUrl;
        private List<Tag> tags;
        private String time;
        private List<Singer> singers;
        private String discographyId;

        public VideoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public VideoBuilder setImageId(String imageId) {
            this.imageId = imageId;
            return this;
        }

        public VideoBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public VideoBuilder setYouTubeUrl(String youTubeUrl) {
            this.youTubeUrl = youTubeUrl;
            return this;
        }

        public VideoBuilder setTags(List<Tag> tags) {
            this.tags = tags;
            return this;
        }

        public VideoBuilder setTime(String time) {
            this.time = time;
            return this;
        }

        public VideoBuilder setSingers(List<Singer> singers) {
            this.singers = singers;
            return this;
        }

        public VideoBuilder setDiscographyId(String discographyId) {
            this.discographyId = discographyId;
            return this;
        }

        public Video build() {
            Video video = new Video();
            video.name = this.name;
            video.imageId = this.imageId;
            video.description = this.description;
            video.youTubeUrl = this.youTubeUrl;
            video.tags = this.tags;
            video.time = this.time;
            video.singers = this.singers;
            video.discographyId = this.discographyId;

            return video;
        }
    }
}
