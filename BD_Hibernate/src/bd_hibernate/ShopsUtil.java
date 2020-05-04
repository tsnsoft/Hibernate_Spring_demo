package bd_hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class ShopsUtil {
    private Session session = null;

    ShopsUtil(Session session) {
        this.session = session;
    }

    public void setDataSource(Session session) {
        this.session = session;
    }

    /**
     * @return 
     * @description получение всех записей
     */
    public List<Shops> selectAll() {
        return (List<Shops>)session.createSQLQuery("SELECT * FROM shops ORDER BY id").addEntity(Shops.class).list();
    }
    
    /**
     * @description удаление всех записей
     */
    public void deleteAll() {
        session.createSQLQuery("DELETE FROM shops").executeUpdate();
        session.flush();
    }
    
    /**
     * @param name
     * @param address
     * @param phone
     * @Description функция добавления новой записи через параметры
     */
    public void append(String name, String address, String phone) {
        Shops shop = new Shops();
        shop.setName(name);
        shop.setAddress(address);
        shop.setPhone(phone);
        session.save(shop);
        session.flush();
    }
       
    /**
     * @param id
     * @return 
     * @Description функция получения записи по id
     */
    public Shops findById(String id) {
        return (Shops) session.get(Shops.class, Integer.parseInt(id));
    }
     
    /**
     * @param name
     * @param address
     * @param phone
     * @param id
     * @Description ф-я обновления записиы
     */
    public void update(String name, String address, String phone, int id) {
        Shops shop = (Shops) session.get(Shops.class, id);
        if (!name.equals(shop.getName())) shop.setName(name);
        if (!address.equals(shop.getAddress())) shop.setAddress(address);
        if (!phone.equals(shop.getPhone())) shop.setPhone(phone);
        session.save(shop);
        session.flush();
    }

    /**
     * @param id
     * @Description удалить запись по id
     */
    public void deleteById(int id) {
        Shops shops = (Shops) session.get(Shops.class, id);
        session.delete(shops);
        session.flush();
    }
    
    /**
     * @param name
     * @param address
     * @param phone
     * @return 
     * @Description получить записи по фильтру
     */
    public List<Shops> getFilter(String name, String address, String phone) {
        Criteria crit = session.createCriteria(Shops.class);
        
        if (!name.equals("")) {
            crit.add(Restrictions.like("name","%"+name+"%",MatchMode.ANYWHERE));
        }

        if (!address.equals("")) {
            crit.add(Restrictions.like("address","%"+address+"%",MatchMode.ANYWHERE));
        }

        if (!phone.equals("")) {
            crit.add(Restrictions.like("phone","%"+phone+"%",MatchMode.ANYWHERE));
        }

        List<Shops> shops = crit.list();
        session.flush();
        return shops;
    }
}