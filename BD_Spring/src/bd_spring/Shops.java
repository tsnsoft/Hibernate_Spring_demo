package bd_spring;

//класс предствления записи в бд
public class Shops {
    int id;       
    String name; 
    String address; 
    String phone;          

    public Shops() {
        this.id = 0;
        this.name = "";
        this.address = "";
        this.phone = "";
    }

    public Shops(String Name, String Adress, String phone) {
        this.id = 0;
        this.name = Name;
        this.address = Adress;
        this.phone = phone;
    }
    
     @Override
    public String toString() {
        return "Shop{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + '}';
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}