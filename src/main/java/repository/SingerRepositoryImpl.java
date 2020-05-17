package repository;

import domain.entities.Singer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class SingerRepositoryImpl implements SingerRepository {

    private EntityManager entityManager;

    public SingerRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("kilata")
                .createEntityManager();
    }

    @Override
    public Singer save(Singer entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Singer> findAll() {
        this.entityManager.getTransaction().begin();

        List<Singer> singers = this.entityManager
                .createQuery("SELECT s FROM Singer s", Singer.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return singers;
    }

    @Override
    public Singer findById(String id) {
        this.entityManager.getTransaction().begin();

        Singer singer = this.entityManager
                .createQuery("SELECT s FROM Singer s WHERE s.id = :id", Singer.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return singer;
    }

    @Override
    public long size() {
        this.entityManager.getTransaction().begin();

        long size = this.entityManager
                .createQuery("SELECT count(s) FROM Singer s", long.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return size;
    }
}
