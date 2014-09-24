package com.quiz.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class AbstractDao {

    protected SessionFactory sf;

    public AbstractDao(SessionFactory sf) {
        this.sf = sf;
    }

    public Query getQuery(String query) {
        return sf.getCurrentSession().createQuery(query);
    }

    public Query getQuery(String query, Object o) {
        return sf.getCurrentSession().createQuery(query).setParameter(0, o);
    }

    public Query getQuery(String query, Object o1, Object o2) {
        return sf.getCurrentSession().createQuery(query).setParameter(0, o1).setParameter(1, o2);
    }
}
