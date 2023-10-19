import java.io.Serializable;

public class Shipment implements Serializable {
    private Product product;
    private int quantity;

    public Shipment(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
