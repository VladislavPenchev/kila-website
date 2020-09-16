package repository;

import domain.entities.Discography;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class DiscographyRepositoryImpl implements DiscographyRepository {

    private EntityManager entityManager;

    public DiscographyRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("kilata")
                .createEntityManager();
    }

    @Override
    public Discography save(Discography entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Discography> findAll() {
        this.entityManager.getTransaction().begin();

        List<Discography> discographies = this.entityManager
                .createQuery("SELECT d FROM Discography d", Discography.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return discographies;
    }

    @Override
    public Discography findById(String id) {
        this.entityManager.getTransaction().begin();

        Discography discography = this.entityManager
                .createQuery("SELECT d FROM Discography d WHERE d.id = :id", Discography.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return discography;
    }

    @Override
    public long size() {
        this.entityManager.getTransaction().begin();

        long size = this.entityManager
                .createQuery("SELECT count(d) FROM Discography d", Long.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return size;
    }
}
