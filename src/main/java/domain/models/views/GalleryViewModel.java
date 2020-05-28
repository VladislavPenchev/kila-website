package domain.models.views;

import java.util.List;

public class GalleryViewModel {
    private String id;
    private String name;
    private List<ImageViewModel> imageViewModels;

    public GalleryViewModel() {
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

    public List<ImageViewModel> getImageViewModels() {
        return imageViewModels;
    }

    public void setImageViewModels(List<ImageViewModel> imageViewModels) {
        this.imageViewModels = imageViewModels;
    }
}
