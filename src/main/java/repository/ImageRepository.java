package repository;

import domain.entities.Image;

import java.util.List;

public interface ImageRepository extends GenericRepository<Image, String>{
    List<Image> findAllByGalleryId(String id);
}
