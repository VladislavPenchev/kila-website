package repository;

import domain.entities.Post;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    private EntityManager entityManager;

    public PostRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("kilata")
                .createEntityManager();
    }

    @Override
    public Post save(Post entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Post> findAll() {
        this.entityManager.getTransaction().begin();

        List<Post> posts = this.entityManager
                .createQuery("SELECT p FROM Post p", Post.class)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return posts;
    }

    @Override
    public Post findById(String id) {
        this.entityManager.getTransaction().begin();

        Post post = this.entityManager
                .createQuery("SELECT p FROM Post v WHERE p.id = :id", Post.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return post;
    }

    @Override
    public long size() {
        this.entityManager.getTransaction().begin();

        long size = this.entityManager
                .createQuery("SELECT count(p) FROM Post p", long.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();
        return size;
    }

}
