package com.ra.repository;

import com.ra.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Category> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category", Category.class).list();
    }

    public Category findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.get(Category.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean save(Category category) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(category);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = findById(id);
        if (category != null) {
            session.delete(category);
            return true;
        } else {
            return false;
        }
    }
    public boolean findByName(String cateName) {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.createQuery(
                "from Category where cateName = :cateName",Category.class)
                .setParameter("cateName",cateName)
                .uniqueResult();
        return category != null;
    }

}
