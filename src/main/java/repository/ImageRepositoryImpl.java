package repository;

import domain.entities.Image;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ImageRepositoryImpl implements ImageRepository {
    private EntityManager entityManager;

    public ImageRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("kilata")
                .createEntityManager();
    }

    @Override
    public Image save(Image entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Image> findAll() {
        this.entityManager.getTransaction().begin();

        List<Image> images = this.entityManager
                .createQuery("SELECT i FROM Image i", Image.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return images;
    }

    @Override
    public Image findById(String id) {
        this.entityManager.getTransaction().begin();

        Image image = this.entityManager
                .createQuery("SELECT i FROM Image i WHERE i.id = :id", Image.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return image;
    }

    @Override
    public long size() {
        this.entityManager.getTransaction().begin();

        long size = this.entityManager
                .createQuery("SELECT count(i) FROM Image i", Long.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return size;
    }


    @Override
    public List<Image> findAllByGalleryId(String id) {
        this.entityManager.getTransaction().begin();

        List<Image> images = this.entityManager
                .createQuery("SELECT i FROM Image i WHERE i.galleryId =:id", Image.class)
                .setParameter("id", id)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return images;
    }
}
