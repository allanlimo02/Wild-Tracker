package Dao;

import Animals.Animal;

import java.util.List;

public interface DaoInterface {
     void  add(Animal animal);
        void updateById(int id);
    void findById(int id);
    List<Animal> findAll();
    void delete(int id);
    List<Animal> deleteAll();
}
