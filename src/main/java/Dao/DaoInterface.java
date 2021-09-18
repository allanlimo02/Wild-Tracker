package Dao;

public interface DaoInterface {
    void add();
    void updateById(int id);
    void findById(int id);
    void find();
    void delete(int id);
    void delete();
}
