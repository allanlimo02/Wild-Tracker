package Dao;

import Animals.Animal;

import java.util.List;

public interface DaoInterface {
    abstract void  add(Animal animal);
    abstract    void updateById(int id);
    void findById(int id);
    List<Animal> findAll();
    void delete(int id);
    List<Animal> deleteAll();
}
