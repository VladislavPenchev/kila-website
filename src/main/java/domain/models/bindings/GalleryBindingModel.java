package domain.models.bindings;

import javax.servlet.http.Part;
import java.util.List;

public class GalleryBindingModel {

    private String name;
    private List<Part> imageFile;

    public GalleryBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Part> getImageFile() {
        return imageFile;
    }

    public void setImageFile(List<Part> imageFile) {
        this.imageFile = imageFile;
    }
}

