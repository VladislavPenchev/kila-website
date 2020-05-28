package domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "galleries")
public class Gallery extends BaseEntity{
    private String name;

    private Gallery() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @OneToMany(mappedBy = "gallery")
//    public List<Image> getImages() {
//        return images;
//    }
//
//    public void setImages(List<Image> images) {
//        this.images = images;
//    }

    public static class GalleryBuilder {
        private String name;
        private List<Image> images;

        public GalleryBuilder setName(String name) {
            this.name = name;
            return this;
        }

//        public GalleryBuilder setImages(List<Image> images) {
//            this.images = images;
//            return this;
//        }

        public Gallery build() {
            Gallery gallery = new Gallery();
            gallery.name = name;
//            gallery.images = images;

            return gallery;
        }
    }
}
