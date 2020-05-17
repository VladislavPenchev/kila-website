package repository;

import domain.entities.Video;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class VideoRepositoryImpl implements VideoRepository{

    private EntityManager entityManager;

    public VideoRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("kilata")
                .createEntityManager();
    }

    @Override
    public Video save(Video entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Video> findAll() {
        this.entityManager.getTransaction().begin();

        List<Video> videos = this.entityManager
                .createQuery("SELECT v FROM Video v", Video.class)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return videos;
    }

    @Override
    public Video findById(String id) {
        this.entityManager.getTransaction().begin();

        Video video = this.entityManager
                .createQuery("SELECT v FROM Video v WHERE v.id = :id", Video.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return video;
    }

    @Override
    public long size() {
        this.entityManager.getTransaction().begin();

        long size = this.entityManager
                .createQuery("SELECT count(v) FROM Video v", long.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return size;
    }
}
