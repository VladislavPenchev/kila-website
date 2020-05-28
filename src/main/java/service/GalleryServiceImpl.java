package service;

import domain.entities.Gallery;
import domain.entities.Image;
import domain.models.bindings.GalleryBindingModel;
import domain.models.views.GalleryViewModel;
import domain.models.views.ImageViewModel;
import org.apache.commons.io.IOUtils;
import repository.GalleryRepository;
import repository.ImageRepository;

import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository galleryRepository;
    private final ImageRepository imageRepository;

    @Inject
    public GalleryServiceImpl(GalleryRepository galleryRepository, ImageRepository imageRepository) {
        this.galleryRepository = galleryRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public boolean saveGallery(GalleryBindingModel galleryBindingModel) throws IOException {

        Gallery gallery = new Gallery.GalleryBuilder()
                .setName(galleryBindingModel.getName())
                .build();

        gallery = this.galleryRepository.save(gallery);

        Image image = null;

        if (galleryBindingModel.getImageFile() != null) {
            List<Part> fileParts = galleryBindingModel.getImageFile();
            for(Part filePart : fileParts) {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

                InputStream filecontent = filePart.getInputStream();
                byte[] fileAsByteArray = IOUtils.toByteArray(filecontent);

                image = new Image.ImageBuilder()
                        .setName(fileName)
                        .setImageContent(fileAsByteArray)
                        .setGalleryId(gallery.getId())
                        .build();

                imageRepository.save(image);
            }
        }

        return gallery != null;
    }

    @Override
    public List<GalleryViewModel> getAllGalleries() {
        List<GalleryViewModel> galleryViewModels = new ArrayList<>();

        List<Gallery> galleries = this.galleryRepository.findAll();

        for (Gallery gal : galleries) {
            GalleryViewModel galleryViewModel = new GalleryViewModel();
            galleryViewModel.setId(gal.getId());
            galleryViewModel.setName(gal.getName());

            List<ImageViewModel> imageViewModels = this.imageRepository
                    .findAllByGalleryId(gal.getId())
                    .stream()
                    .map(img -> {
                        ImageViewModel imageViewModel = new ImageViewModel();
                        imageViewModel.setId(img.getId());
                        imageViewModel.setName(img.getName());

                        String base64Encoded = null;

                        byte[] encodeBase64 = Base64.getEncoder().encode(img.getImageContent());
                        try {
                            base64Encoded = new String(encodeBase64, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                        imageViewModel.setImage_content(base64Encoded);

                        return imageViewModel;
                    })
                    .collect(Collectors.toList());

            galleryViewModel.setImageViewModels(imageViewModels);

            galleryViewModels.add(galleryViewModel);
        }

        return galleryViewModels;
    }

}
