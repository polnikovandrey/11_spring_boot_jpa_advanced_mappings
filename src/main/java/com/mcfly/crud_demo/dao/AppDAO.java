package com.mcfly.crud_demo.dao;

import com.mcfly.crud_demo.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);
}
