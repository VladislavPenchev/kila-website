package repository;

import domain.entities.Gallery;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class GalleryRepositoryImpl implements GalleryRepository {

    private EntityManager entityManager;

    public GalleryRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("kilata")
                .createEntityManager();
    }

    @Override
    public Gallery save(Gallery entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Gallery> findAll() {
        this.entityManager.getTransaction().begin();

        List<Gallery> galleries = this.entityManager
                .createQuery("SELECT g FROM Gallery g", Gallery.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return galleries;
    }

    @Override
    public Gallery findById(String id) {
        this.entityManager.getTransaction().begin();

        Gallery gallery = this.entityManager
                .createQuery("SELECT g FROM Gallery g WHERE g.id = :id", Gallery.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return gallery;
    }

    @Override
    public long size() {
        this.entityManager.getTransaction().begin();

        long size = this.entityManager
                .createQuery("SELECT count(g) FROM Gallery g", Long.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return size;
    }
}
