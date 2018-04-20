package com.example.blogweb.DAO;

import com.example.blogweb.entity.MyEntry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository(value = "entryDAO")
@Transactional(rollbackOn = Exception.class)
public class EntryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(final MyEntry myEntry){
        Session session = this.sessionFactory.getCurrentSession();
        session.save(myEntry);
    }

    public void update(final MyEntry myEntry){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(myEntry);
    }

    public void delete(final MyEntry myEntry){
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(myEntry);
    }

    public MyEntry findById(final int id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(MyEntry.class, id);
    }

    public List<MyEntry> findAll(){
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("FROM MyEntry", MyEntry.class).getResultList();
    }
}
