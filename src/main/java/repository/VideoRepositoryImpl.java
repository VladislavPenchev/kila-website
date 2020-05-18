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
                .createQuery("SELECT COUNT(v) FROM domain.entities.Video v", Long.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return size;
    }

    @Override
    public List<Video> getLatestVideos() {
        this.entityManager.getTransaction().begin();

        //TODO: TOP 5

        this.entityManager.getTransaction().commit();

        return null;
    }

    @Override
    public List<Video> findVideosByNumber(int start, int recordsPerPage) {
        this.entityManager.getTransaction().begin();

        List<Video> videosPerPage = this.entityManager
                .createQuery("SELECT v FROM Video v order by v.id", Video.class)
                .setFirstResult(start)
                .setMaxResults(recordsPerPage)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return videosPerPage;
    }
}
