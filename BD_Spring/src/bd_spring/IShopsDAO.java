package bd_spring;

import java.util.List;
import javax.sql.DataSource;

public interface IShopsDAO {
    void setDataSource(DataSource ds);

    //вствка записи а бд
    void insert(Shops customer);

    //добавление записи в бд
    void append(String name, String adress, String phone);

    //удалить запись по if
    void deleteById(int id);

    //получить запись по id
    List<Shops> findById(String id);

    //получить все записи
    List<Shops> selectAll();
 
    //получить записи по фильтру
    List<Shops> getFilter(String name, String address, String phone);
    
    //удалить все записи
    void deleteAll();

    //обновить записиь
    void update(String name, String adress, String phone, int id);
}