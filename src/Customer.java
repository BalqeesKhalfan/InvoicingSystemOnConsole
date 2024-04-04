import java.util.Objects;

public class Customer {
    Integer id;
    String phoneNumber;
    Name name;
    public String fullName(){
        return name.first+" "+ name.middle+" "+name.last;
    }

    public Customer(Integer id, String phoneNumber, Name name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", name=" + name +
                '}';
    }
}
