package bd_spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ShopsDAO implements IShopsDAO{
    private DataSource dataSource;
    
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    /**
     * @description получение всех записей
     */
    public List<Shops> selectAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select * from shops ", new RowManager());
    }
    
    @Override
    /**
     * @description удаление всех записей
     */
    public void deleteAll() {  // Реализация удаления всех запией
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE from shops");
    }

    @Override
    /**
     * @Description функция вставки новой записи одним бъектом
     */
    public void insert(Shops customer) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO shops (name, address, phone) VALUES(?,?,?)",
                new Object[]{customer.getName(), customer.getAddress(), customer.getPhone()});
    }

    @Override
    /**
     * @Description функция добавления новой записи через параметры
     */
    public void append(String name, String address, String phone) {  // Реализация добавления новой записи
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO shops (name, address, phone) VALUES(?,?,?)", new Object[]{name, address, phone});
    }

    
    @Override
    /**
     * @Description функция получения записи по id
     */
    public List<Shops> findById(String id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM shops WHERE id = ?";
        List<Shops> shops = select.query(sql, new Object[]{id}, new RowManager());
        return shops;
    }
    
    @Override
    /**
     * @Description ф-я обновления записиы
     */
    public void update(String name, String address, String phone, int id) {
        JdbcTemplate update = new JdbcTemplate(dataSource);
        update.update("UPDATE shops SET name = ?, address = ?, phone = ? WHERE id = ?", new Object[]{name, address, phone, id});
    }

    @Override
    /**
     * @Description удалить запись по id
     */
    public void deleteById(int id) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("DELETE FROM shops WHERE id = ?", new Object[]{id});
    }
    
    @Override
    /**
     * @Description получить записи по фильтру
     */
    public List<Shops> getFilter(String name, String address, String phone) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM shops WHERE ";
        String where = "";
        Object[] obj = new Object[]{};

        if (!name.equals("")) {
            where += "name LIKE ?";
            obj = appendValue(obj, "%" + name + "%");
        }

        if (!address.equals("")) {
            if (!where.equals("")) where += ", AND ";
            where += "address LIKE ?";
            obj = appendValue(obj, "%" + address + "%");
        }

        if (!phone.equals("")) {
            if (!where.equals("")) where += ", AND ";
            where += "phone LIKE ?";
            obj = appendValue(obj, "%" + phone + "%");
        }

        sql += where;

        List<Shops> shops = select.query(sql, obj, new RowManager());
        return shops;
    }

    //добавление данных в объект
    private Object[] appendValue(Object[] obj, Object newObj) {
	ArrayList<Object> temp = new ArrayList<>(Arrays.asList(obj));
	temp.add(newObj);
	return temp.toArray();
  }
}