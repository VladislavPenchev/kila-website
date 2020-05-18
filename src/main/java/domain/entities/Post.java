package domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{
    private String name;
    private String description;
    private String imageId;

    private Post() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "imageId")
    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public static class PostBuilder {
        private String name;
        private String description;
        private String imageId;

        public PostBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PostBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public PostBuilder setImageId(String imageId) {
            this.imageId = imageId;
            return this;
        }

        public Post build() {
            Post post = new Post();
            post.name = this.name;
            post.description = this.description;
            post.imageId = this.imageId;

            return post;
        }
    }
}
