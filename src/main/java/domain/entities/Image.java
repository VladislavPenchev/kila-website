package domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image extends BaseEntity {
    private String name;
    private byte[] imageContent;
    private String galleryId;
    private String discographyId;

    private Image() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Column(name = "image_content", columnDefinition = "LONGBLOB")
    public byte[] getImageContent() {
        return imageContent;
    }

    public void setImageContent(byte[] imageContent) {
        this.imageContent = imageContent;
    }

    @Column(name = "gallery_id")
    public String getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(String galleryId) {
        this.galleryId = galleryId;
    }

    @Column(name = "discography_id")
    public String getDiscographyId() {
        return discographyId;
    }

    public void setDiscographyId(String discographyId) {
        this.discographyId = discographyId;
    }

    public static class ImageBuilder {
        private String name;
        private byte[] imageContent;
        private String galleryId;
        private String discographyId;

        public ImageBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ImageBuilder setImageContent(byte[] imageContent) {
            this.imageContent = imageContent;
            return this;
        }

        public ImageBuilder setGalleryId(String galleryId) {
            this.galleryId = galleryId;
            return this;
        }

        public ImageBuilder setDiscographyId(String discographyId) {
            this.discographyId = discographyId;
            return this;
        }

        public Image build() {
            Image image = new Image();
            image.name = name;
            image.imageContent = imageContent;
            image.galleryId = galleryId;
            image.discographyId = discographyId;

            return image;
        }
    }

}
