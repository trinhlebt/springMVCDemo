package com.example.blogweb.model;

import com.example.blogweb.DAO.EntryDAO;
import com.example.blogweb.entity.MyEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MyEntryModel {

    @Autowired
    private EntryDAO entryDAO;

    public List<MyEntry> findAll(){
        return entryDAO.findAll();
    }

    public void save(final MyEntry myEntry){
        entryDAO.save(myEntry);
    }

    public void update(final MyEntry myEntry){
        entryDAO.update(myEntry);
    }

    public void delete(final int id){
        MyEntry myEntry = entryDAO.findById(id);
        if(myEntry != null) {
            entryDAO.delete(myEntry);
        }
    }
}
