package com.pepinho.ad.biblioteca.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BookJPADao implements DAO<Book>{

    private EntityManager em;

    public BookJPADao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Book get(long id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("Select b from Book b", Book.class);
        return query.getResultList();
    }

    @Override
    public void save(Book book) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(book);
        et.commit();
    }

    @Override
    public void update(Book book) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(book);
        et.commit();
    }

    @Override
    public void delete(Book book) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(book);
        et.commit();
    }

    @Override
    public boolean deleteById(long id) {
        Book book = get(id);
        if(book != null){
            delete(book);
            return true;
        }
        return false;
    }

    @Override
    public List<Long> getAllIds() {
        TypedQuery<Long> query = em.createQuery("Select b.idBook from Book b", Long.class);
        return query.getResultList();
    }

    @Override
    public void updateLOB(Book book, String f) {
    }

    @Override
    public void updateLOBById(long id, String f) {

    }

    @Override
    public void deleteAll() {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createQuery("Delete from Book").executeUpdate();
        et.commit();
    }
}
