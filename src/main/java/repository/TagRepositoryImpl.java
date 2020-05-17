package repository;

import domain.entities.Tag;
import domain.entities.Video;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class TagRepositoryImpl implements TagRepository{

    private EntityManager entityManager;

    public TagRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("kilata")
                .createEntityManager();
    }

    @Override
    public Tag save(Tag entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Tag> findAll() {
        this.entityManager.getTransaction().begin();

        List<Tag> videos = this.entityManager
                .createQuery("SELECT t FROM Tag t", Tag.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return videos;
    }

    @Override
    public Tag findById(String id) {
        this.entityManager.getTransaction().begin();

        Tag tag = this.entityManager
                .createQuery("SELECT t FROM Tag t WHERE t.id = :id", Tag.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return tag;
    }

    @Override
    public long size() {
        this.entityManager.getTransaction().begin();

        long size = this.entityManager
                .createQuery("SELECT count(t) FROM Tag t", long.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return size;
    }
}
