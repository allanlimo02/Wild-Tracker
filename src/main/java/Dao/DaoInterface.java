package Dao;

import Animals.Endangered;

public interface DaoInterface {
    void add(Endangered endangered);
    void updateById(int id);
    void findById(int id);
    void find();
    void delete(int id);
    void delete();
}
