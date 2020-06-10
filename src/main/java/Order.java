import com.github.javafaker.Faker;
import java.util.UUID;

class Order {
    private String id;
    private String orderStatus;
    private String firstName;
    private String lastName;
    private String streetAddress;

    Order() {
        genId();
        orderStatus = "to complete";
        Faker faker = new Faker();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.streetAddress = faker.address().streetAddress();
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    private void genId() {
        if (id == null)
            id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                '}';
    }
}
