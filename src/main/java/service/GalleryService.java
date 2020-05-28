package service;

import domain.models.bindings.GalleryBindingModel;
import domain.models.bindings.PostBindingModel;
import domain.models.views.GalleryViewModel;
import domain.models.views.PostViewModel;

import java.io.IOException;
import java.util.List;

public interface GalleryService {
    boolean saveGallery(GalleryBindingModel galleryBindingModel) throws IOException;

    List<GalleryViewModel> getAllGalleries();
}
