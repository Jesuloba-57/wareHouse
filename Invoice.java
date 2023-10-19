import java.util.Objects;

public class Invoice {
    private Product product;
    private Member member;
    private int quantity;

    public Invoice(Product product, Member member, int quantity) {
        this.product = product;
        this.member = member;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Member getMember() {
        return member;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Invoice other = (Invoice) obj;
        return Objects.equals(this.product, other.product) &&
                Objects.equals(this.member, other.member) &&
                this.quantity == other.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, member, quantity);
    }

    public String toString() {
        return "Product Name: " + product.getProductName() + " Member: " + member.getName() + " Quantity: " + quantity;
    }
}
